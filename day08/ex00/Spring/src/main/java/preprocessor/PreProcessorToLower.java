package preprocessor;

public class PreProcessorToLower implements PreProcessor {

    @Override
    public String selectCase(String message) {

        return message.toLowerCase();
    }
}
