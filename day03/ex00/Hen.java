
public class Hen extends Thread {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    private int count;

    public Hen(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(ANSI_YELLOW + "Hen" + ANSI_RESET);
        }
    }
}
