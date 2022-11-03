import java.io.*;

public class Program {
    private static double similarity;

    public static void main(String[] args) {
		ftDictionary dictionary = new ftDictionary();
	
        if (args.length != 2) {
            System.out.println("2 FILES MUST BE TRANSFERRED TO THE PROGRAM");
            System.exit(-1);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) {
            dictionary.fillDictionary(args[0]);
			dictionary.fillDictionary(args[1]);
			
			ftVector vectorOne = new ftVector(dictionary.size());
			ftVector vectorTwo = new ftVector(dictionary.size());
    		
			vectorOne.fill(args[0], dictionary.getInstance());
			vectorTwo.fill(args[1], dictionary.getInstance());

            similarity = Calculator.getInstance().calculate(vectorOne.getInstance(), vectorTwo.getInstance());
            
			System.out.println("Similarity = " + Math.floor(similarity * 100) / 100.0);

            for (String word : dictionary.getInstance()) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}