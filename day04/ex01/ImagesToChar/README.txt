
Steps to run program: (or use make commands: build jar run clean)

Step 1: Compile files to the 'target' directory:
    javac -d target src/java/edu/school21/printer/app/App.java src/java/edu/school21/printer/logic/Logic.java
Step 2: Copy resources:
    cp -r src/resources ./target/resources
Step 3: Create jar file:
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
Step 4: Run program:
    java -jar target/images-to-chars-printer.jar . 0
