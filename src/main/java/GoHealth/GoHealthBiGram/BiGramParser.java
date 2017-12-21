package GoHealth.GoHealthBiGram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Its Bigram parser class contains the main logic and supported methods.
 * @author sdasara
 *
 */
public class BiGramParser {

	/**
	 * method to read the data from inputed file
	 * 
	 * @return String
	 */
	public static String readFileData() {
		String data = "";
		try {
			data = new String(Files.readAllBytes(Paths.get(BiGramMain.getFileName())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static String[] loadContentToList() {
		String[] data = readFileData().split(" ");
		return data;

	}

	public static String[] getContent() {
		return loadContentToList();
	}

	/**
	 * Method to parse and convert to bigrams of inputed text filed
	 * 
	 * @return List<String>
	 */
	public static List<String> listOfBiGrams() {
		String[] data = getContent();
		List<String> BiGramsList = new ArrayList<String>();

		for (int i = 0, j = i + 1; j < data.length; i++, j++) {
			String bg = data[i] + " " + data[j];
			BiGramsList.add(bg);
		}
		return BiGramsList;

	}

	/**
	 * Method to Display the bigrams
	 */
	public static void displayListOfBiGrams() {
		List<String> listOfBgs = listOfBiGrams();
		for (String bgs : listOfBgs) {
			System.out.println(bgs);
		}
	}

	/**
	 * Method to get the total number of bigrams in a file
	 * 
	 * @return Integer
	 */
	public static int totalBiGramsCount() {
		int count = listOfBiGrams().size();
		System.out.println(count);
		return count;

	}

	/**
	 * Method to get the histogram of the bigrams.
	 * 
	 * @return Map<String,Integer>
	 */
	public static Map<String, Integer> BiGramRepeatedCounts() {
		
		Map<String, Integer> BiGramMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);

		List<String> totalBgs = listOfBiGrams();

		for (int i = 0; i < totalBgs.size(); i++) {
			String bg = totalBgs.get(i);
			if (BiGramMap.containsKey(bg)) {
				BiGramMap.put(bg, BiGramMap.get(bg) + 1);
			} else {
				BiGramMap.put(bg, 1);
			}
		}
		Set<String> bgKeySet = BiGramMap.keySet();
		for (String BiGram : bgKeySet) {
			System.out.println(BiGram + ": " + BiGramMap.get(BiGram));
		}

		return BiGramMap;

	}

}
