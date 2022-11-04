
public class Egg implements Runnable {
    private int count;
    private Monitor monitor;

    public Egg(int count, Monitor monitor) {
        this.count = count;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                monitor.callEgg();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
