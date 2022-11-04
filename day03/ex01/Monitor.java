
public class Monitor {
    private Category category = Category.EGG;

    private enum Category {
        EGG,
        HEN
    }

    public synchronized void callEgg() throws InterruptedException {
        if (category != Category.EGG) {
            wait();
        }
        System.out.println("Egg");
        category = Category.HEN;
        notify();
    }

    public synchronized void calltHen() throws InterruptedException {
        if (category != Category.HEN) {
            wait();
        }
        System.out.println("Hen");
        category = Category.EGG;
        notify();
    }
}
