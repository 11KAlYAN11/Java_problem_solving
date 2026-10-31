# Nothing-Space

Will give brief about repo here later (It's working?)

change 1

change 2

change 3

## How to run any program

This repo is a Maven project (`pom.xml`). IntelliJ and VS Code both read it automatically, so there are no scripts to run, no terminal steps, and debugging works.

- **IntelliJ IDEA**: open this folder (File → Open). If you open the parent `repos` folder instead, right-click `pom.xml` → **Add as Maven Project** (one time only). Then click the green ▶ next to any `main` → **Run** or **Debug**.
- **VS Code**: open this folder (or the parent `repos` folder) and wait for the Java status bar to say it's ready. Click **Run** / **Debug** above any `main`, or press **F5** with the file open.
- **Terminal** (optional): `javac -d target/classes -sourcepath src/main/java src/main/java/basics/Hello.java` then `java -cp target/classes basics.Hello`

## Rules that keep every file runnable

The IDE compiles the **whole** repo before running a single file, so one broken file stops all of them.

1. Code lives in `src/main/java/<Topic>/` and starts with `package <Topic>;`. Create files with **New → Java Class** so the IDE writes this line for you.
2. A helper class used by only one program goes **inside** that program's class, e.g. `static class Node { ... }`. Two top-level classes with the same name in one folder cause a "duplicate class" error, and then nothing runs. This was the old problem.
3. If a file is half-finished and doesn't compile, comment out the broken part before moving on.
4. `OPPS_ADV/VirtualThread*.java` need JDK 21. `pom.xml` skips them while JDK 17 is installed (the steps to switch are in the comment there).
