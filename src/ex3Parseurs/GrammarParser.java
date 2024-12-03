package ex3Parseurs;

public class GrammarParser {

    private String input;
    private int index;

    public GrammarParser(String input) {
        this.input = input;
        this.index = 0;
    }

    public boolean parse() {
        return parseS() && index == input.length();
    }

    private boolean parseS() {
        int startPos = index;

        if (match('b')) {
            if (parseS() && match('b')) {
                return true;
            }
            index = startPos;
        }

        if (match('c')) {
            if (parseA() && match('c')) {
                return true;
            }
            index = startPos;
        }

        return false;
    }

    private boolean parseA() {
        int startPos = index;

        if (match('b')) {
            if (parseA() && parseA()) {
                return true;
            }
            index = startPos;
        }

        if (match('c')) {
            if (parseA() && parseS() && match('A') && match('b')) {
                return true;
            }
            index = startPos;
        }

        if (match('d') && match('c') && match('b')) {
            return true;
        }

        return false;
    }

    private boolean match(char c) {
        if (index < input.length() && input.charAt(index) == c) {
            index++;
            return true;
        }
        return false;
    }
}
