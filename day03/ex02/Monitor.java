
public class Monitor {
    private int[]   data;
    private int     total;

    public Monitor(int[] data) {
        this.data = data;
    }

    public synchronized void calculate(int first, int last, int num) {
        int sum = 0;

        for (int i = first; i <= last; i++) {
            sum += data[i];
        }
        System.out.println("Thread " + num + ": from " + first + " to " + last
                + " sum is " + sum);
        total += sum;
    }

    public int  getTotal() {
        return  total;
    }
}
