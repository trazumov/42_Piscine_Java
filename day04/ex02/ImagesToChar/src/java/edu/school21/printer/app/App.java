package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.Args;
import edu.school21.printer.logic.Logic;

public class App {

    public static void main(String[] args) {
        try {
            Args jArgs = new Args();
            
            JCommander.newBuilder()
                    .addObject(jArgs)
                    .build()
                    .parse(args);

            Logic display = new Logic(jArgs, "/resources/image.bmp");
            display.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}