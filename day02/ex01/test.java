import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		ftDictionary dict = new ftDictionary();

		dict.fillDictionary("1.txt");
		System.out.println(dict.size());
		
		dict.printdata();
	}
}
