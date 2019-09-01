// Version: 2019090102
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class Submit {
    private static void debug(String m) { /*System.out.println(m);*/ }
    private static final String host = "https://domjudge.cs.au.dk";
    private static final String data_filename = "submit_data.txt";
    private static final String extension = "java";
    private static final String contest = null;

    private String task;
    private String username;
    private String password;
    private String mainClass;

    // 0: not a multi task; i >= 1: part i (out of "variants") of a multi task.
    private int multiTask;
    private int variants;
    // Delimiter used between the problem id and the number of variants.
    private static final char DELIMITER = '-';

    public static void submit(String taskID, String username, String password) {
        try {
            try(Writer file = new FileWriter(data_filename)) {
                try(PrintWriter out = new PrintWriter(file)) {
                    out.println(taskID);
                    out.println(username);
                    out.println(password);
                    out.println("");
                    out.println("This file contains the Task ID, username and password");
                    out.println("last used when submitting a solution.");
                    out.println("This file is used when you call Submit.submit() with no arguments.");
                }
            }
            submit();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void submit() {
        try {
            Submit s = new Submit();
            String task;
            System.out.println(
                "============================================================");
            if (!s.validateFilenames()) return;
            try {
                try(Reader file = new FileReader(data_filename)) {
                    BufferedReader in = new BufferedReader(file);
                    task = in.readLine();
                    s.username = in.readLine();
                    s.password = in.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("No password saved. " +
                                   "Run submit(taskID, username, password) instead.");
                return;
            }
            s.ensureLoginCookie();
            int delimiter = task.indexOf(DELIMITER);
            if (delimiter == -1) {
                s.task = task;
                s.multiTask = 0;
                s.variants = 1;
                s.outputFeedback(s.doSubmit());
            } else {
                s.variants = Integer.parseInt(task.substring(delimiter+1));
                task = task.substring(0, delimiter);
                String judging = null;
                for (int i = 1; i <= s.variants; i += 1) {
                    s.task = task + i;
                    s.multiTask = i;
                    judging = s.doSubmit();
                    if (!"correct".equals(judging)) break;
                }
                s.outputFeedback(judging);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String cookie;
    private String boundary;
    private byte[] boundaryBytes;
    private byte[] finishBoundaryBytes;

    public Submit() throws IOException {
        boundary = UUID.randomUUID().toString();
        boundaryBytes =
            ("--" + boundary + "\r\n").getBytes("UTF-8");
        finishBoundaryBytes =
            ("--" + boundary + "--").getBytes("UTF-8");
    }

    public String doSubmit() throws IOException {
        int contestId = getContestId();
        int problemId = getProblemId(contestId);
        if (problemId == -1) {
            System.out.println("Could not find any task of name " + task + ".");
            if (multiTask > 1) {
                System.out.println("Maybe this problem only has " + (multiTask-1) + " parts.");
            }
            return null;
        }
        String submissionId;
        HttpURLConnection http = makePostSubmissionRequest(contestId);
        sendSubmissionForm(http, problemId);
        if (getResponseCode(http) == 401) {
            System.out.println("Wrong username or password. " +
                               "Please run submit(taskID, username, password) again.");
            return null;
        }
        submissionId = readResponse(http);
        if (submissionId.startsWith("error: ")) {
            System.out.println(submissionId);
            System.out.println(
                "Check your Task ID and call " +
                "submit(taskID, username, password) again.");
            if (multiTask > 1) {
                System.out.println("Maybe this problem only has " + (multiTask-1) + " parts.");
            }
            return null;
        }
        System.out.println("Submitted to " +
                           host + "/team/submission/" +
                           submissionId);
        int timeout = 60;
        return pollJudging(submissionId, timeout);
    }

    private String getJsonNaive(String contents, String key, int startIndex) {
        String needle = "\"" + key + "\": \"";
        int i = contents.indexOf(needle, startIndex);
        if (i == -1) return null;
        int j = contents.indexOf("\"", i + needle.length());
        return contents.substring(i + needle.length(), j);
    }

    private int getContestId() throws IOException {
        URL url = new URL(host + "/api/v4/contests");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setDoOutput(true);
        String contents = readResponse(http);
        return Integer.parseInt(getJsonNaive(contents, "id", 0));
    }

    private int getProblemId(int contestId) throws IOException {
        URL url = new URL(host + "/api/v4/contests/" + contestId + "/problems");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setDoOutput(true);
        String contents = readResponse(http);
        int i = contents.indexOf("{");
        while (i != -1) {
            String shortName = getJsonNaive(contents, "short_name", i);
            if (task.equals(shortName))
                return Integer.parseInt(getJsonNaive(contents, "id", i));
            i = contents.indexOf("{", i+1);
        }
        return -1;
    }

    public boolean outputFeedback(String judging) {
        if (judging == null) return false;
        if (judging.equals("correct")) {
            if (variants <= 1) {
                System.out.println("Points: 1 out of 1");
                System.out.println("Congratulations, your solution is correct!");
            } else if (multiTask > 1) {
                System.out.println("Points: " + multiTask + " out of " + variants);
                System.out.println("Congratulations, you get an additional point for speed!");
            } else {
                System.out.println("Points: " + multiTask + " out of " + variants);
                System.out.println("Congratulations, your solution is correct!");
            }
            return true;
        }
        if (variants <= 1) {
            System.out.println("Points: 0 out of 1");
        } else {
            System.out.println("Points: " + (multiTask-1) + " out of " + variants);
        }
        if (judging.equals("timelimit")) {
            if (multiTask > 1) {
                System.out.println("Your solution is correct, " +
                                   "but you do not get extra points for speed.");
            } else {
                System.out.println("Sorry, but your solution is not efficient enough " +
                                   "(time limit exceeded).");
            }
        } else if (judging.equals("timeout")) {
            System.out.println(
                "Judging is taking too long. What's going on?");
        } else if (judging.equals("compiler-error")) {
            System.out.println(
                "Sorry, but the judge could not compile your solution!");
        } else if (judging.equals("wrong-answer")) {
            System.out.println(
                "Sorry, but your solution gives the wrong answer on one or more of the " +
                "hidden test cases.");
            System.out.println(
                "If you have used System.out.println() in your solution, then you must " +
                "remove these lines before submitting to the judge!");
            System.out.println(
                "If not, you need to find and fix the errors in your solution, " +
                "and try submitting again.");
        } else {
            System.out.println(
                "Sorry, but something is wrong with your solution (" + judging + ")");
        }
        return false;
    }

    private String getLoginCsrfToken(String contents) throws IOException {
        String needle = "<input type=\"hidden\" name=\"_csrf_token\" value=\"";
        int pos = contents.indexOf(needle);
        if (pos == -1)
            throw new RuntimeException("Could not get CSRF token from login page");
        int quotepos = contents.indexOf('"', pos + needle.length());
        return contents.substring(pos + needle.length(), quotepos);
    }

    private String prepareLoginPostData(String username, String password) throws IOException {
        HttpURLConnection http = makeGetLoginRequest();
        String response = readResponse(http);
        ensureCookie(http);
        debug("Cookie: " + cookie);
        String csrfToken = getLoginCsrfToken(response);
        debug("CSRF: " + csrfToken);
        return "_csrf_token=" + csrfToken +
            "&_username=" + username +
            "&_password=" + password;
    }

    private void ensureCookie(HttpURLConnection http) throws IOException {
        String setCookie = http.getHeaderField("Set-Cookie");
        if (setCookie == null) {
            if (cookie == null) {
                throw new RuntimeException("Did not get Set-Cookie header");
            }
            return;
        }
        int semi = setCookie.indexOf(';');
        if (semi != -1)
            setCookie = setCookie.substring(0, semi);
        debug("Set cookie to " + setCookie);
        cookie = setCookie;
    }

    private void ensureLoginCookie() throws IOException {
        String postData = prepareLoginPostData(username, password);
        HttpURLConnection http = makePostLoginRequest();
        try {
            try(OutputStream out = http.getOutputStream()) {
                try(PrintWriter print = new PrintWriter(out)) {
                    print.print(postData);
                }
            }
            // Force the HttpURLConnection to send the request:
            http.getInputStream();
            if (http.getResponseCode() >= 400)
                throw new RuntimeException("Unexpected failure response code");
            // TODO: At this point the response code should be 302 (redirect).
            // We could check whether we are redirected to /login (wrong password)
            // or / (correct password) and report an error here,
            // instead of waiting until doSubmit() with reporting the error.
        } catch (ConnectException e) {
            String msg = "Could not connect. Is your internet connection working?";
            System.out.println(msg);
            throw new RuntimeException(msg, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to login", e);
        }
        ensureCookie(http);
        debug("Obtained login cookie");
    }

    private String pollJudging(String submissionId, int timeout) throws IOException {
        int waitTime = 0;
        int polls = 0;
        while (true) {
            int t = Math.min(5, polls);
            try {
                if (t > 0) {
                    Thread.sleep(t * 1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String judging = getSubmissionJudging(submissionId);
            waitTime += t;
            polls += 1;
            if (judging == null) {
                if (waitTime >= timeout) {
                    return "timeout";
                }
                continue;
            }
            return judging;
        }
    }

    private String getSubmissionJudging(String submissionId) throws IOException {
        HttpURLConnection http = makeGetSubmissionRequest(submissionId);
        String contents = readResponse(http);
        final String notFound = "Submission not found for this team or not judged yet.";
        if (contents.indexOf(notFound) != -1)
            return null;  // Try again
        final String pending = "<span class=\"sol sol_queued\">";
        if (contents.indexOf(pending) != -1)
            return null;  // Try again
        // <p>Result: <span class="sol sol_incorrect">wrong-answer</span></p>
        final String incorrect = "<span class=\"sol sol_incorrect\">";
        int pos = contents.indexOf(incorrect);
        if (pos != -1) {
            pos += incorrect.length();
            int i = contents.indexOf('<', pos);
            if (i == -1) throw new RuntimeException("No </span> found");
            String code = contents.substring(pos, i);
            if (code.equals("correct")) throw new RuntimeException("Incorrect and correct");
            return code;
        }
        final String correct = "<span class=\"sol sol_correct\">";
        if (contents.indexOf(correct) != -1)
            return "correct";
        final String compileError = "<span class=\"badge badge-danger\">";
        if (contents.indexOf(compileError) != -1)
            return "compiler-error";
        System.out.println(contents);
        throw new RuntimeException("Failed to parse submission_details.php output");
    }

    private HttpURLConnection makeLoginRequest(boolean isPost) throws IOException {
        URL url = new URL(host + "/login");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setRequestMethod(isPost ? "POST" : "GET");
        http.setDoOutput(true);
        if (cookie != null)
            http.setRequestProperty("Cookie", cookie);
        http.setInstanceFollowRedirects(false);
        if (isPost) {
            http.setRequestProperty(
                    "Content-Type",
                    "application/x-www-form-urlencoded");
            // Enable streaming mode with default settings
            http.setChunkedStreamingMode(0);
        }
        return http;
    }

    private HttpURLConnection makeGetLoginRequest() throws IOException {
        return makeLoginRequest(false);
    }

    private HttpURLConnection makePostLoginRequest() throws IOException {
        return makeLoginRequest(true);
    }

    private HttpURLConnection makePostSubmissionRequest(int contestId) throws IOException {
        URL url = new URL(host + "/api/v4/contests/" + contestId + "/submissions");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        String authorization = username + ":" + password;
        String authEncoded = Base64.getEncoder().encodeToString(authorization.getBytes("UTF-8"));
        http.setRequestProperty("Authorization", "Basic " + authEncoded);
        http.setRequestProperty(
                "Content-Type",
                "multipart/form-data; charset=UTF-8; boundary=" + boundary);
        // Enable streaming mode with default settings
        http.setChunkedStreamingMode(0);
        return http;
    }

    private HttpURLConnection makeGetSubmissionRequest(String submissionId) throws IOException {
        URL url = new URL(host + "/team/submission/" + submissionId);
        debug("Connect to " + url);
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setDoOutput(true);
        debug("Set cookie " + cookie);
        if (cookie != null)
            http.setRequestProperty("Cookie", cookie);
        // Enable streaming mode with default settings
        http.setChunkedStreamingMode(0);
        return http;
    }

    private static String join(String delimiter, Iterable<String> items) {
        String s = "";
        StringBuilder b = new StringBuilder();
        for (String x : items) {
            b.append(s);
            b.append(x);
            s = delimiter;
        }
        return b.toString();
    }

    private boolean validateFilenames() throws IOException {
        Set<String> r = new HashSet<String>();
        for (String fileName : getFilenames()) {
            try(FileReader file = new FileReader(fileName)) {
                BufferedReader rd = new BufferedReader(file);
                while (true) {
                    String line = rd.readLine();
                    if (line == null) break;
                    // Note, we must break the following string into two pieces
                    // to avoid Submit.java detecting itself as a task file.
                    String needle = "public static void " + "main(String[]";
                    if (line.indexOf(needle) != -1)
                        r.add(fileName);
                }
            }
        }
        if (r.size() > 1) {
            System.out.println("Error: Multiple task files found (" +
                               join(", ", r) + ").");
            System.out.println("       You need to make a new " +
                               "BlueJ project for each task.");
            return false;
        }
        if (r.size() == 0) {
            System.out.println("Error: No task file found.");
            return false;
        }
        String fileName = r.iterator().next();
        mainClass = fileName.replace(".java", "");
        return true;
    }

    private void sendSubmissionForm(HttpURLConnection http, int problemId) throws IOException {
        try(OutputStream out = http.getOutputStream()) {
            for (String filename : getFilenames()) {
                try(InputStream file = new FileInputStream(filename)) {
                    out.write(boundaryBytes);
                    sendFile(out, "code[]", file, filename);
                }
            }

            out.write(boundaryBytes);
            sendField(out, "problem", problemId + "");

            out.write(boundaryBytes);
            sendField(out, "language", extension);

            out.write(boundaryBytes);
            sendField(out, "entry_point", mainClass);

            out.write(finishBoundaryBytes);
        }
    }

    private List<String> getFilenames() {
        List<String> r = new ArrayList<String>();
        for (final File fileEntry : new File(".").listFiles()) {
            String n = fileEntry.getName();
            if (n.startsWith("_") || n.startsWith(".")) {
                continue;
            } else if (n.endsWith(".java")) {
                r.add(n);
            }
        }
        return r;
    }

    private int getResponseCode(HttpURLConnection http) throws IOException {
        int responseCode;
        try {
            http.getInputStream();
            responseCode = http.getResponseCode();
            if (responseCode >= 300)
                throw new RuntimeException("Unexpected failure response code");
        } catch (IOException e) {
            http.getErrorStream();
            responseCode = http.getResponseCode();
            if (http.getResponseCode() < 300)
                throw new RuntimeException("Unexpected success response code");
        }
        return responseCode;
    }

    private String readResponse(HttpURLConnection http) throws IOException {
        InputStream inputStream;
        try {
            inputStream = http.getInputStream();
            if (http.getResponseCode() >= 300)
                throw new RuntimeException("Unexpected failure response code");
        } catch (ConnectException e) {
            String msg = "Could not connect. Is your internet connection working?";
            System.out.println(msg);
            throw new RuntimeException(msg, e);
        } catch (IOException e) {
            inputStream = http.getErrorStream();
            if (inputStream == null)
                throw new RuntimeException(e);
            if (http.getResponseCode() < 300)
                throw new RuntimeException("Unexpected success response code");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = in.readLine()) != null) {
            sb.append(line + "\n");
        }
        in.close();
        String result = sb.toString();
        if (http.getResponseCode() == 500 && result.startsWith("error: "))
            return result;
        if (http.getResponseCode() >= 300)
            throw new RuntimeException(
                "HTTP " + http.getResponseCode() + ": " + result);
        return result;
    }

    private void sendFile(OutputStream out, String name, InputStream in, String filename) throws IOException {
        // XXX: This doesn't strip whitespace characters such as CR and LF.
        debug("Submitting " + filename);
        String o = "Content-Disposition: form-data; name=\"" +
            name.replace("\\", "\\\\").replace("\"", "\\\"") +
            "\"; filename=\"" +
            filename.replace("\\", "\\\\").replace("\"", "\\\"") +
            "\"\r\n\r\n";
        out.write(o.getBytes("UTF-8"));
        byte[] buffer = new byte[2048];
        for (int n = 0; n >= 0; n = in.read(buffer))
            out.write(buffer, 0, n);
        out.write("\r\n".getBytes("UTF-8"));
    }

    private void sendField(OutputStream out, String name, String field) throws IOException {
        // XXX: This doesn't strip whitespace characters such as CR and LF.
        debug(name + "=" + field);
        String o = "Content-Disposition: form-data; name=\"" +
            name.replace("\\", "\\\\").replace("\"", "\\\"") +
            "\"\r\n\r\n";
        out.write(o.getBytes("UTF-8"));
        out.write(URLEncoder.encode(field, "UTF-8").getBytes("UTF-8"));
        out.write("\r\n".getBytes("UTF-8"));
    }
}
