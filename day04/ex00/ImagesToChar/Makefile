SRC = src/java/edu/school21/printer/app/App.java \
		src/java/edu/school21/printer/logic/Logic.java

SRC_IMG = it.bmp

WHITE_CHAR = .

BLACK_CHAR = 0

APP = edu.school21.printer.app.App

TARGET_FOLDER = target

all: build run

build:
	javac -d $(TARGET_FOLDER) $(SRC)

run:
	java -cp $(TARGET_FOLDER)/ $(APP) $(WHITE_CHAR) $(BLACK_CHAR) $(SRC_IMG)

clean:
	@rm -r $(TARGET_FOLDER)