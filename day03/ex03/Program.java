import java.io.IOException;

public class Program {
	private static int threadsCount;
	private static ThreadDownloader[] threads;
	private static UrlManager manager;
	public static void main(String[] args) throws IOException {

		try {
            checkArguments(args);
            createAll();
            runThreads();
        } catch (NumberFormatException e) {
            System.out.print("Illegal argument: ");
            System.out.println(e.getMessage());
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }

	}

	private static void checkArguments(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--threadsCount=")) {
            System.out.println("Specify argument using '--threadsCount='");
            System.exit(-1);
        }
        threadsCount = Integer.parseInt(args[0].substring("--threadsCount=".length()));

        if (threadsCount < 1) {
            System.out.println("Invalid argument threadsCount. Must be greater than 0");
            System.exit(-1);
        }
    }

	private static void createAll() throws IOException {
        manager = new UrlManager();
        threads = new ThreadDownloader[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new ThreadDownloader(i + 1, manager);
        }
    }

	private static void runThreads() {
        for (int i = 0; i < threadsCount; i++) {
            threads[i].start();
        }
    }
	
}
