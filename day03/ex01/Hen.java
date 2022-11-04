
public class Hen implements Runnable {
    private int count;
    private Monitor monitor;

    public Hen(int count, Monitor monitor) {
        this.count = count;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                monitor.calltHen();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
