package ex3Parseurs;

public class Main {

	public static void main(String[] args) {
        String[] testStrings = {"cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbbcr", "cdcbbb", "cdcb", ""};

        for (String test : testStrings) {
            GrammarParser parser = new GrammarParser(test);
            boolean result = parser.parse();
            System.out.println("Chaine: \"" + test + "\" est " + (result ? "Valid" : "Invalid"));
        }
    }

}
