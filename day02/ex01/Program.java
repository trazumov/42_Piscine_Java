import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private static int[] vectorOne;
    private static int[] vectorTwo;
    //private static final List<String> dictionary = new ArrayList<>(); //
    private static double similarity;

    public static void main(String[] args) {
		ftDictionary dictionary = new ftDictionary();

        if (args.length != 2) {
            System.out.println("2 FILES MUST BE TRANSFERRED TO THE PROGRAM");
            System.exit(-1);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) { //
            //BufferedReader readerOne = new BufferedReader(new FileReader(args[0]));
            //BufferedReader readerTwo = new BufferedReader(new FileReader(args[1]));
            //fillDictionary(readerOne);
            //fillDictionary(readerTwo);
            //readerOne.close();
            //readerTwo.close();
			dictionary.fillDictionary(args[0]);
			dictionary.fillDictionary(args[1]);

            vectorOne = new int[dictionary.size()];
            vectorTwo = new int[dictionary.size()];
            BufferedReader readerOne = new BufferedReader(new FileReader(args[0]));
            BufferedReader readerTwo = new BufferedReader(new FileReader(args[1]));
            fillVector(readerOne, vectorOne, dictionary.getInstance());
            fillVector(readerTwo, vectorTwo, dictionary.getInstance());
            readerOne.close();
            readerTwo.close();
            calculate();
            System.out.println("Similarity = " + Math.floor(similarity * 100) / 100.0);

            for (String word : dictionary.getInstance()) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void calculate() {
        double numerator = 0;
        double denominatorA = 0;
        double denominatorB = 0;

        for (int i = 0; i < vectorOne.length; i++) {
            numerator += vectorOne[i] * vectorTwo[i];
            denominatorA += vectorOne[i] * vectorOne[i];
            denominatorB += vectorTwo[i] * vectorTwo[i];
        }
        similarity = numerator / (Math.sqrt(denominatorA) * Math.sqrt(denominatorB));
    }

    private static void fillVector(BufferedReader reader, int[] vector, List<String> dictionary) throws IOException {
        String str;
        int index;

        while ((str = reader.readLine()) != null) {
            String[] words = str.replaceAll("\\p{Punct}", "")
                                .toLowerCase().split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    index = dictionary.indexOf(word);
                    vector[index] += 1;
                }
            }
        }
    }

    // private static void fillDictionary(BufferedReader reader) throws IOException {
    //     String str;

    //     while ((str = reader.readLine()) != null) {
    //         String[] words = str.replaceAll("\\p{Punct}", "")
    //                             .toLowerCase().split("\\s+");

    //         for (String word : words) {
    //             if (!dictionary.contains(word) && !word.isEmpty()) {
    //                 dictionary.add(word);
    //             }
    //         }
    //     }
    // }
}