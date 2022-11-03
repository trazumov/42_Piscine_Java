import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ftDictionary {
	private List<String> INSTANCE;
	
	public ftDictionary(){
		INSTANCE = new ArrayList<>();
	}

	public List<String> getInstance() {
        return INSTANCE;
    }

	public int size() {
		return INSTANCE.size();
	}

	public void printdata() {
		for (int i = 0; i < INSTANCE.size(); i++) {
			System.out.println(INSTANCE.get(i));
		  }
	}


	public void fillDictionary(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String row;

			while ((row = reader.readLine()) != null) {
				String[] words = row.replaceAll("\\p{Punct}", "")
				.toLowerCase().split("\\s+");

				for (String word : words) {
					if (!INSTANCE.contains(word) && !word.isEmpty()) {
						INSTANCE.add(word);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
            System.out.println(e.getMessage());
		}
	}
}
