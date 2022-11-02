import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseSignatures {
    private static final Map<String, String> pairSignatures = new HashMap<>();

    public static void parseSignatures(List<String> file) {
        for (String row : file) {
            if (!row.isEmpty()) {
                String[] data = row.split(",");
                pairSignatures.put(data[0].trim(), data[1].trim());
            }
        }
    }

    public static Map<String, String> getFormats() {
        return pairSignatures;
    }

    public static boolean HasKey(String signature) {
        for (String value : pairSignatures.values()) {
            if (signature.startsWith(value)) {
                return true;
            }
          }
        return false;
    }
}