You can find all commands in Makefile, peer

#1 Download libraries:
    https://repo1.maven.org/maven2/com/beust/jcommander...
    https://repo1.maven.org/maven2/com/diogonunes/JCDP/...

#2 Extract libraries to directory target

#3. Compile files:
    javac -d target -cp lib/\* src/java/edu/school21/printer/app/App.java src/java/edu/school21/printer/logic/*.java

#4. Copy resources to target/resources

#5. Create jar file:
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

#6. Run program:
    java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN

About JCommander https://jcommander.org/
About Jcolor https://github.com/dialex/JColor