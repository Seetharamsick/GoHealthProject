package GoHealth.GoHealthBiGram;

public class BiGramMain {

	public BiGramMain(String fName){
		fileName=fName;
	}
	public static String fileName;
	
	public static String getFileName() {
		return fileName;
	}
	public static void setFileName(String fileName) {
		BiGramMain.fileName = fileName;
	}

	public static void main(String[] args) {
		fileName=args[0];
		
		System.out.println("\n====Input File Name:  ");
		System.out.println(fileName);
		
		System.out.println("\n====Test to Read the entire Data from the given input file======");
		System.out.println(BiGramParser.readFileData());
		
		System.out.println("\n====Test to Get the total no of possible BiGrams from the given input file======");
		BiGramParser.totalBiGramsCount();
		
		System.out.println("\n====Test to Get the list of all possible BiGrams from the given input file======");
		BiGramParser.displayListOfBiGrams();
		
		System.out.println("\n====Test to Get the histogram of bigrams from the given input file======");
		BiGramParser.BiGramRepeatedCounts();
		
	}
}
