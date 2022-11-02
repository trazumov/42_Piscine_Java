import java.util.Map;

public class FileBuffer {
    private String buffer = "";

    public FileBuffer() {}

    public void bufferFileTypes(Map<String, String> pairSignatures, String signature) {
        for (Map.Entry <String, String> item : pairSignatures.entrySet()) {
            if (signature.startsWith(item.getValue())) {
                this.buffer += item.getKey() + "\n";
                break;
            }
        }
    }

    public String getBuffer() {
        return buffer;
    }
}