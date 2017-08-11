import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class Submit {
    private static final String host = "http://domjudge.cs.au.dk";
    private static final String data_filename = "submit_data.txt";
    private static final String extension = "java";
    private static final String contest = null;

    private String task;
    private String username;
    private String password;

    public static void submit(String task, String username, String password) {
        try {
            try(Writer file = new FileWriter(data_filename)) {
                try(PrintWriter out = new PrintWriter(file)) {
                    out.println(task);
                    out.println(username);
                    out.println(password);
                    out.println("");
                    out.println("This file contains the task, username and password");
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
            System.out.println(
                "============================================================");
            try {
                try(Reader file = new FileReader(data_filename)) {
                    BufferedReader in = new BufferedReader(file);
                    s.task = in.readLine();
                    s.username = in.readLine();
                    s.password = in.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("No password saved. " +
                                   "Run submit(task, username, password) instead.");
                return;
            }
            if (!s.getLoginCookie()) {
                System.out.println("Wrong username or password. " +
                                   "Please run submit(task, username, password) again.");
                return;
            }
            String submissionId;
            HttpURLConnection http = s.makePostSubmissionRequest();
            s.sendSubmissionForm(http);
            submissionId = s.readResponse(http);
            if (submissionId.startsWith("error: ")) {
                System.out.println(submissionId);
                System.out.println(
                    "Check your task name and call " +
                    "submit(task, username, password) again.");
                return;
            }
            System.out.println("Submitted to " +
                               host + "/team/submission_details.php?id=" +
                               submissionId);
            int timeout = 60;
            String judging = s.pollJudging(submissionId, timeout);
            if (judging.equals("correct")) {
                System.out.println("Congratulations, your solution is correct!");
            } else if (judging.equals("timeout")) {
                System.out.println(
                    "Judging is taking too long (> " + timeout + " s). What's going on?");
            } else if (judging.equals("compiler-error")) {
                System.out.println(
                    "Sorry, but the judge could not compile your solution!");
            } else if (judging.equals("wrong-answer")) {
                System.out.println(
                    "Sorry, but your solution did not work on the hidden test cases.");
                System.out.println("Find and fix the errors, and try submitting again!");
            } else {
                System.out.println(
                    "Sorry, but something is wrong with your solution (" + judging + ")");
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

    private boolean getLoginCookie() throws IOException {
        HttpURLConnection http = makePostLoginRequest();
        try(OutputStream out = http.getOutputStream()) {
            try(PrintWriter print = new PrintWriter(out)) {
                print.print("cmd=login&login=" + username + "&passwd=" + password);
            }
        }
        InputStream inputStream;
        try {
            inputStream = http.getInputStream();
            if (http.getResponseCode() >= 400)
                throw new RuntimeException("Unexpected failure response code");
        } catch (IOException e) {
            return false;
        }
        cookie = http.getHeaderField("Set-Cookie");
        if (cookie == null) {
            throw new RuntimeException("Got success response from login.php " +
                                       "but no Set-Cookie header");
        }
        return true;
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
        final String notFound = "<p>Submission not found for this team or not judged yet.</p>";
        if (contents.indexOf(notFound) != -1)
            return null;  // Try again
        final String pending = "<p>Result: <span class=\"sol sol_queued\">";
        if (contents.indexOf(pending) != -1)
            return null;  // Try again
        // <p>Result: <span class="sol sol_incorrect">wrong-answer</span></p>
        final String incorrect = "<p>Result: <span class=\"sol sol_incorrect\">";
        int pos = contents.indexOf(incorrect);
        if (pos != -1) {
            pos += incorrect.length();
            int i = contents.indexOf('<', pos);
            if (i == -1) throw new RuntimeException("No </span> found");
            String code = contents.substring(pos, i);
            if (code.equals("correct")) throw new RuntimeException("Incorrect and correct");
            return code;
        }
        final String correct = "<p>Result: <span class=\"sol sol_correct\">";
        if (contents.indexOf(correct) != -1)
            return "correct";
        System.out.println(contents);
        throw new RuntimeException("Failed to parse submission_details.php output");
    }

    private HttpURLConnection makePostLoginRequest() throws IOException {
        URL url = new URL(host + "/public/login.php");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        http.setInstanceFollowRedirects(false);
        http.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded");
        // Enable streaming mode with default settings
        http.setChunkedStreamingMode(0);
        return http;
    }

    private HttpURLConnection makePostSubmissionRequest() throws IOException {
        URL url = new URL(host + "/api/submissions");
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setRequestMethod("POST"); // PUT is another valid option
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
        URL url = new URL(host + "/team/submission_details.php?id=" + submissionId);
        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setDoOutput(true);
        if (cookie != null)
            http.setRequestProperty("Cookie", cookie);
        // Enable streaming mode with default settings
        http.setChunkedStreamingMode(0);
        return http;
    }

    private void sendSubmissionForm(HttpURLConnection http) throws IOException {
        try(OutputStream out = http.getOutputStream()) {
            for (String filename : getFilenames()) {
                try(InputStream file = new FileInputStream(filename)) {
                    out.write(boundaryBytes);
                    sendFile(out, "code[]", file, filename);
                }
            }

            out.write(boundaryBytes);
            sendField(out, "shortname", task);

            out.write(boundaryBytes);
            sendField(out, "langid", extension);

            if (contest != null) {
                out.write(boundaryBytes);
                sendField(out, "contest", contest);
            }

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

    private String readResponse(HttpURLConnection http) throws IOException {
        InputStream inputStream;
        try {
            inputStream = http.getInputStream();
            if (http.getResponseCode() >= 300)
                throw new RuntimeException("Unexpected failure response code");
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
        String o = "Content-Disposition: form-data; name=\"" +
            name.replace("\\", "\\\\").replace("\"", "\\\"") +
            "\"\r\n\r\n";
        out.write(o.getBytes("UTF-8"));
        out.write(URLEncoder.encode(field, "UTF-8").getBytes("UTF-8"));
        out.write("\r\n".getBytes("UTF-8"));
    }
}
