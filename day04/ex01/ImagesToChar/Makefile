SRC =	src/java/edu/school21/printer/app/App.java \
		src/java/edu/school21/printer/logic/Logic.java

PROGRAM = images-to-chars-printer.jar

TARGET_FOLDER = target

CHAR_WHITE = .

CHAR_BLACK = 0

MANIFEST = src/manifest.txt

all: build jar run

build:
	javac -d $(TARGET_FOLDER) $(SRC)
	cp -r src/resources ./$(TARGET_FOLDER)/resources

jar:
	jar cfm $(TARGET_FOLDER)/$(PROGRAM) $(MANIFEST) -C $(TARGET_FOLDER) .

run:
	java -jar $(TARGET_FOLDER)/$(PROGRAM) $(CHAR_WHITE) $(CHAR_BLACK)

clean:
	@rm -r $(TARGET_FOLDER)