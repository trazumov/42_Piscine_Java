SRC =	src/java/edu/school21/printer/app/App.java \
		src/java/edu/school21/printer/logic/*.java
PROGRAM = images-to-chars-printer.jar

MANIFEST = src/manifest.txt

TARGET_FOLDER = target

LIB_FOLDER = lib

JCommander_VERSION = 1.82

SRC_JCommander = https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-$(JCommander_VERSION).jar

OUT_JCommander = $(LIB_FOLDER)/jcommander-$(JCommander_VERSION).jar

JCDP_VERSION = 4.0.2

SRC_JCDP = https://repo1.maven.org/maven2/com/diogonunes/JCDP/$(JCDP_VERSION)/JCDP-$(JCDP_VERSION).jar

OUT_JCDP = $(LIB_FOLDER)/JCDP-$(JCDP_VERSION).jar

WHITE_COLOR = RED

BLACK_COLOR = GREEN

all: loadlibs extractJCommander extractJCDP compile jar run

mkdir:
	@echo "Create directories.."
	@mkdir $(TARGET_FOLDER) && mkdir $(LIB_FOLDER)

loadlibs:
	@echo "Download JCommander and JCDP.."
	@curl $(SRC_JCommander) -o $(OUT_JCommander)
	@curl $(SRC_JCDP) -o $(OUT_JCDP)

extractJCommander:
	cd target; pwd ; echo "Extract JCommaner" ; jar xf ../$(OUT_JCommander)

extractJCDP:
	cd target; pwd ; echo "Extract JCDP" ; jar xf ../$(OUT_JCDP)

compile:
	@echo "Compile files.." ;
	javac -d $(TARGET_FOLDER) -cp lib/\* $(SRC) ;
	@echo "Copy resources" ;
	cp -r src/resources ./$(TARGET_FOLDER)/resources

jar:
	@echo "Create jar file"
	jar cfm $(TARGET_FOLDER)/$(PROGRAM) $(MANIFEST) -C $(TARGET_FOLDER) .

run:
	java -jar $(TARGET_FOLDER)/$(PROGRAM) --white=$(WHITE_COLOR) --black=$(BLACK_COLOR)

clean:
	@rm -r $(TARGET_FOLDER)/* $(LIB_FOLDER)/*