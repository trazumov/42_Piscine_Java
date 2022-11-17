package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String selectCase(String message) {

        return message.toUpperCase();
    }
}
