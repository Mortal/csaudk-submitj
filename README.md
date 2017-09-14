FADS Submit program for BlueJ
=============================

Intended audience: Students of *Grundlæggende Algoritmer og Datastrukturer* (FADS), Aarhus University.

In FADS, you have to solve a number of programming tasks along the way.
The programming tasks should be solved in Java using the [BlueJ](https://www.bluej.org/) programming environment.

To solve a programming task, first find the task either in
[Blackboard](https://blackboard.au.dk/webapps/blackboard/execute/launcher?type=Course&id=_66529_1)
or in the [tasks](tasks) directory of this repository.
Read the task description, and start solving the task!

To upload your solution, you need three things:

  * Task ID (from the task description)
  * Username (`fads17-daN-MM`, where `N` is your class and `MM` is your Blackboard group number)
  * Password (from your TA)

If you have technical problems, contact Mathias Rav on the Blackboard discussion board.

1. Open BlueJ

   ![Blank BlueJ](screenshots/001-blank-bluej.png)

1. Click "New Project..."

   ![Project menu](screenshots/002-project-menu.png)

1. Save the new project somewhere

   ![New project dialog](screenshots/003-new-project-dialog.png)

1. In the edit menu, select "Add Class from File..."

   ![Edit menu](screenshots/004-edit-menu.png)

1. Select the skeleton Java file for the problem you're solving and the Submit.java file

   ![Select Java files](screenshots/005-select-java-files.png)

1. Click "Compile" to ensure that the code you're given can compile. If it doesn't compile, write to Mathias Rav on the Blackboard discussion board.

   ![Click compile](screenshots/006-click-compile.png)

1. Click `testAll()` on `Submit` to see that some or all of the tests currently fail

   ![Click testAll](screenshots/007-click-testall.png)

1. Read the test output to see that some tests have `FAIL` written

   ![Test failures](screenshots/008-test-failures.png)

1. Open the editor on the class for this task (that is, not the Submit class, but the class named after the problem you're solving)

   ![Open editor](screenshots/009-open-editor.png)

1. Sometimes BlueJ opens the file to a random line. If this happens, scroll up to the top, since you don't have to edit most of the methods in the given file.

   ![Open to random line](screenshots/010-open-to-random-line.png)

1. At the top of the file, you can now start implementing the algorithm to solve the given task

   ![Scroll to top](screenshots/011-scroll-to-top.png)

   ![Solve exercise](screenshots/012-solve-exercise.png)

1. Click Compile to see if you have any syntax or type errors to correct

   ![Click compile](screenshots/013-click-compile.png)

1. If your code compiled successfully, you can now click `testAll()` again to see if the tests pass

   ![Click testAll](screenshots/014-click-testall.png)

1. If the test output doesn't say `FAIL` anywhere, you're done!

   ![Test successes](screenshots/015-test-successes.png)

1. Right click `Submit` and choose `submit(String taskID, String username, String password)`.
   Remember to put "quotes" around the three strings.
   Find the Task ID in the task description.

   ![Click submit](screenshots/016-click-submit.png)

1. Enter the username and password your TA gave you, and enter the ID for this
   task. If the task ends in `"-2"`, that means you can get 1 point for a
   correct solution and an additional 1 point for a fast solution.

   ![Enter credentials](screenshots/017-enter-credentials.png)

1. Your code will be submitted to the automated judge, and after a while you will see the judgement.
   Remember to switch to the console window of BlueJ if it doesn't appear automatically.

   ![Submit success](screenshots/018-submit-success.png)
