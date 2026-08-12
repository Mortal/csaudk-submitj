ADS programming exercises
==========================

Intended audience: Students of *Algorithms and Data Structures* (ADS), Aarhus University.

In ADS, you have to solve a number of programming tasks along the way.
The programming tasks should be solved in Java using the [IntelliJ](https://www.jetbrains.com/idea/) programming environment.

To solve a programming task, first find the task either in
Brightspace or in the [tasks list](tasks/README.md) of this repository.
Read the task description, and start solving the task!

To upload your solution, you need three things:

  * Task ID (from the task description)
  * Username (`adsYY-djXXXX`, where `YY` is the current year and `XXXX` is your programming group number, found on Brightspace grade)
  * Password (from Brightspace grade)

If you have technical problems, contact Daniel Anker Hermansen on the Brightspace discussion board.
See also the list of [common mistakes](#common-mistakes).

Step-by-step guide for IntelliJ
------------------
1. Create a new java project normally.
1. Remove the Main.java file from the src folder.
1. Add the needed files from the specific task to the src folder, along with the Submit.java file.
1. To test the implementation, open the Submit.java file. In the main method at the top, add calls
   to the static test methods in the provided files for the task, and run the code.
1. To submit the code, uncomment the line with the submit call in the main method, add the needed credentials, and run the code.


Common mistakes
---------------

* **Submitting code that calls System.out for debugging.**
  System.out.println() is a good tool to use if you can't find out why your solution doesn't work.
  However, the judge gets confused if you leave in calls to System.out.println()
  when submitting your code, since it looks at the output of the main() method
  to determine if your solution is correct.
  Remember to comment out any System.out-lines in your own code before calling submit()!

If you believe there are other common mistakes that should be mentioned in this list,
let us know on the Brightpsace discussion board.
