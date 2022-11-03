import java.io.*;
import java.util.List;

public class ftVector {
	private int[] INSTANCE;

	public ftVector(int size) {
		INSTANCE = new int[size];
	}

	public int[] getInstance() {
		return this.INSTANCE;
	}

	public void fill(String file, List<String> dictionary) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String row;
			int index;

			while ((row = reader.readLine()) != null) {
				String[] words = row.replaceAll("\\p{Punct}", "")
                                .toLowerCase().split("\\s+");
				for (String word : words) {
					if (!word.isEmpty()) {
						index = dictionary.indexOf(word);
						INSTANCE[index] += 1;
					}
				}
			}
			reader.close();
		} catch (IOException e) {
            System.out.println(e.getMessage());
		}
	}
}
