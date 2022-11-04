import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UrlManager {
	private static AtomicInteger counter = new AtomicInteger(0);
	private static int filesCount;
	private HashMap<Integer, String> urlMap = new HashMap<>();

	public synchronized boolean isAllDownloaded() {
        return (counter.intValue() >= filesCount);
    }

	public int getKey() {
		counter.getAndIncrement();
		return counter.intValue();
	}

	public String getValue(int key) {
		return urlMap.get(key);
	}

	public UrlManager() throws IOException {
        List<String> urlList = Files.readAllLines(Paths.get("files_urls.txt"));
        
		for (String row : urlList) {
			String[] keyValue = row.split("\\s+");
			urlMap.put(Integer.parseInt(keyValue[0]), keyValue[1]);
		}
		if (urlList.size() == 0) {
            throw new RuntimeException("There are no URLs in the file 'files_urls.txt'");
        }
		else {
			filesCount = urlList.size();
		}
    }
}
