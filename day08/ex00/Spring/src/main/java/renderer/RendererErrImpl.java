package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String message) {
        System.err.println(preProcessor.selectCase(message));
    }
}
