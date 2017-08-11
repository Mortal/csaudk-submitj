Submit client written in Java
=============================

This Java class enables students working in [BlueJ](https://www.bluej.org)
to submit solutions to [DOMjudge](https://www.domjudge.org).

See also the [Dockerized DOMjudge setup](https://github.com/Mortal/csaudk-domserver).

Usage
-----

When the student has created a Java solution with a `public static void main(String[] args)`
method suitable for the DOMjudge problem definition, the static `submit()`
method is called on the `Submit` class to submit all `*.java` files to DOMjudge.

The first time a problem is submitted, the student must pass to `submit()`
the problem ID and their username and password for DOMjudge.
On subsequent submissions of the same problem, `submit()` can be invoked without arguments
to reuse the previous credentials.

The `submit()` method will poll DOMjudge while waiting for the problem to be judged.

Implementation
--------------

Although third-party Java classes such as the `Apache HttpClient`
would make implementing `Submit` a breeze,
the current implementation uses only the `HttpURLConnection` facilities
in the Java standard library.

The `Submit` client makes the following HTTP requests:

* POST to `/public/login.php` to enable later polling for the judging result.
  If an HTTP error (status code ≥ 400) is returned, this is presented to the student
  as "Wrong username of password".
* POST to `/api/submissions`, using HTTP Basic Auth for authentication
  (same as the official DOMjudge client).
* GET `/team/submission_details.php?id=`*id* repeatedly until the response doesn't
  contain "Submission not found" (i.e. not compiled yet) or `<span class="sol sol_queued">`
  (i.e. compiled but not judged yet).

When making HTTP POSTs, the POST payload is written directly without using any
HTTP helpers, since the Java standard library does not know how to construct HTTP POST data.

The student's credentials are stored in the file `submit_data.txt`
which also contains a helpful description of what the file is.
