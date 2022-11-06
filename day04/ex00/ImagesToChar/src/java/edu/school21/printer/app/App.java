package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        checkParameters(args);

        try {
            char white = args[0].charAt(0);
            char black = args[1].charAt(0);
            Logic display = new Logic(white, black, args[2]);
            display.display();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkParameters(String[] args) {
        if (args.length != 3) {
            System.out.println("Specify input parameters: WHITE_CHAR and BLACK_CHAR and FILEPATH");
            System.exit(-1);
        }

        if (args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("WHITE_CHAR and BLACK_CHAR should be chars");
            System.exit(-1);
        }
    }
}