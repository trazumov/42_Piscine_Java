
import java.util.Arrays;
import java.util.Random;

public class Program {
    private static int          arraySize, threadsCount;
    private static int[]        array;
    private static SubThread[]  threads;
    private static Monitor      monitor;
    private static final int MAX_ARR_SIZE = 2_000_000;
    private static final int MODULO = 1000;

    public static void main(String[] args) {
        try {
            checkArgs(args);
            createAll();
            runThreads();
            System.out.println("Sum by threads: " + monitor.getTotal());
        } catch (NumberFormatException e) {
            System.out.print("Illegal argument: ");
            System.out.println(e.getMessage());
        }
    }

    private static void checkArgs(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=")
                || !args[1].startsWith("--threadsCount=")) {
            System.out.println("Specify arguments using '--arraySize=' && '--threadsCount='");
            System.exit(-1);
        }
        arraySize = Integer.parseInt(args[0].substring("--arraySize=".length()));
        threadsCount = Integer.parseInt(args[1].substring("--threadsCount=".length()));

        if (arraySize > MAX_ARR_SIZE || threadsCount < 1 || threadsCount > arraySize) {
            System.out.println("Illegal argument for arraySize or threadsCount");
            System.exit(-1);
        }
    }

    private static void createAll() {
        int threadsArraySection, posFrom, posTo = 0;
        int n = 0;
        array = new int[arraySize];
        threads = new SubThread[threadsCount];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MODULO);
        }
        System.out.println("Sum: " + Arrays.stream(array).sum());
        monitor = new Monitor(array);
        threadsArraySection = arraySize / threadsCount;

        for (int i = 0; i < (threads.length - 1); i++, n++) {
            posFrom = threadsArraySection * n;
            posTo = posFrom + threadsArraySection - 1;
            threads[i] = new SubThread((i + 1), posFrom, posTo, monitor);
        }

        if (arraySize % threadsCount != 0) {
            threadsArraySection = arraySize - (threadsArraySection * (threadsCount - 1));
        }

        if (threadsCount > 1) {
            threads[threads.length - 1] = new SubThread(threads.length,
                    posTo + 1, posTo + threadsArraySection, monitor);
        } else {
            threads[0] = new SubThread(1, 0, arraySize - 1, monitor);
        }
    }

    private static void runThreads() {
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }

            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
