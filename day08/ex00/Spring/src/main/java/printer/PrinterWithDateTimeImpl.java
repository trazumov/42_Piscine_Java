package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;
    private LocalDateTime time;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
        this.time = LocalDateTime.now();
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public void print(String message) {
        renderer.render(time + ": " + message);
    }
}
