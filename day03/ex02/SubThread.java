
public class SubThread extends Thread {
    private int     threadNum;
    private int     posFrom;
    private int     posTo;
    private Monitor monitor;

    public SubThread(int threadNum, int posFrom, int posTo, Monitor monitor) {
        this.posFrom = posFrom;
        this.posTo = posTo;
        this.monitor = monitor;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        monitor.calculate(posFrom, posTo, threadNum);
    }
}
