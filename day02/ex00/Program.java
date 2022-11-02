import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
    private static final FileBuffer fileBuffer = new FileBuffer();

    public static void main(String[] args) {
		String currentSignature;

        try (FileOutputStream outputFile = new FileOutputStream("result.txt");
             Scanner input = new Scanner(System.in)) {
				ParseSignatures.parseSignatures(Files.readAllLines(Paths.get(("signatures.txt"))));

            while (true) {
                String filepath = input.nextLine();

                if (filepath.equals("42")) {
                    outputFile.write(fileBuffer.getBuffer().getBytes(), 0, fileBuffer.getBuffer().length());
                    break;
                }
                ByteFile file = new ByteFile(filepath);
				currentSignature = file.getSignature();

				if (ParseSignatures.HasKey(currentSignature)) {
					fileBuffer.bufferFileTypes(ParseSignatures.getFormats(), file.getSignature());
					System.out.println("PROCESSED");
				} else {
					System.out.println("UNDEFINED");
				}
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
