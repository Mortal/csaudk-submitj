import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.UUID;

public class Submit {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // From https://stackoverflow.com/a/35013372/1570972
    private void sendPost() throws IOException {
        URL url = new URL("https://www.example.com/login");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        sendForm(http);
    }

    private void sendForm(HttpURLConnection http) throws IOException {
        String boundary = UUID.randomUUID().toString();
        byte[] boundaryBytes =
            ("--" + boundary + "\r\n").getBytes("UTF-8");
        byte[] finishBoundaryBytes =
            ("--" + boundary + "--").getBytes("UTF-8");
        http.setRequestProperty(
            "Content-Type",
            "multipart/form-data; charset=UTF-8; boundary=" + boundary);

        // Enable streaming mode with default settings
        http.setChunkedStreamingMode(0);

        // Send our fields:
        try(OutputStream out = http.getOutputStream()) {
            // Send our header (thx Algoman)
            out.write(boundaryBytes);

            // Send our first field
            sendField(out, "username", "root");

            // Send a separator
            out.write(boundaryBytes);

            // Send our second field
            sendField(out, "password", "toor");

            // Send another separator
            out.write(boundaryBytes);

            // Send our file
            try(InputStream file = new FileInputStream("test.txt")) {
                sendFile(out, "identification", file, "text.txt");
            }

            // Finish the request
            out.write(finishBoundaryBytes);
        }
    }

    private void sendFile(OutputStream out, String name, InputStream in, String filename) throws IOException {
        String o = "Content-Disposition: form-data; name=\"" +
            URLEncoder.encode(name, "UTF-8") +
            "\"; filename=\"" +
            URLEncoder.encode(filename, "UTF-8") +
            "\"\r\n\r\n";
        out.write(o.getBytes("UTF-8"));
        byte[] buffer = new byte[2048];
        for (int n = 0; n >= 0; n = in.read(buffer))
            out.write(buffer, 0, n);
        out.write("\r\n".getBytes("UTF-8"));
    }

    private void sendField(OutputStream out, String name, String field) throws IOException {
        String o = "Content-Disposition: form-data; name=\"" +
            URLEncoder.encode(name, "UTF-8") + "\"\r\n\r\n";
        out.write(o.getBytes("UTF-8"));
        out.write(URLEncoder.encode(field, "UTF-8").getBytes("UTF-8"));
        out.write("\r\n".getBytes("UTF-8"));
    }
}
