package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printer.PrinterWithPrefixImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = context.getBean(PrinterWithPrefixImpl.class);
        printer.setPrefix("Prefix ");
        printer.print("Hello!") ;
    }
}
