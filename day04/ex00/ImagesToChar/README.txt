Steps to run program: (or use make commands: build run clean)

Step 1: Compile files to the 'target' directory:
    javac -d target src/java/edu/school21/printer/app/App.java src/java/edu/school21/printer/logic/Logic.java
Step 2: Run program:
    java -cp target/ edu.school21.printer.app.App WHITE_CHAR BLACK_CHAR PATH_TO_IMAGE