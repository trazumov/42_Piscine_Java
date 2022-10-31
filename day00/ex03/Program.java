import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long testResults = 0;
        String input;

        for (int week = 1; week < 19; week++) {
            long minEvaluation = 10;
            long newEvaluation;
            input = scan.next();

            if (input.equals("42")) {
                printResults(testResults);
                break;
            } else if (!input.equals("Week")) {
                scan.close();
                illegalArgument();
            }

            if (week != findInt(scan)) {
                scan.close();
                illegalArgument();
            }

            for (int i = 0; i < 5; i++) {
                newEvaluation = findInt(scan);

                if (newEvaluation < 1 || newEvaluation > 9) {
                    scan.close();
                    illegalArgument();
                }

                if (newEvaluation < minEvaluation) {
                    minEvaluation = newEvaluation;
                }
            }
            testResults = testResults * 10 + minEvaluation;

            if (week == 18) {
                printResults(testResults);
                break;
            }
        }
        scan.close();
    }

    public static void illegalArgument() {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }

    public static int findInt(Scanner scan) {
        if (!scan.hasNextInt()) {
            scan.close();
            illegalArgument();
        }
        int num = scan.nextInt();

        return num;
    }

    public static void printResults(long tests) {
        long len = 1;
        long i;

        for (; tests / len > 10; len *= 10);

        for (int week = 1; tests != 0; week++, len /= 10) {
            i = tests / len;
            System.out.print("Week " + week + " ");

            if (i == 1) {
                System.out.println("=>");
            } else if (i == 2) {
                System.out.println("==>");
            } else if (i == 3) {
                System.out.println("===>");
            } else if (i == 4) {
                System.out.println("====>");
            } else if (i == 5) {
                System.out.println("=====>");
            } else if (i == 6) {
                System.out.println("======>");
            } else if (i == 7) {
                System.out.println("=======>");
            } else if (i == 8) {
                System.out.println("========>");
            } else if (i == 9) {
                System.out.println("=========>");
            }
            tests = tests - len * i;
        }
    }
}