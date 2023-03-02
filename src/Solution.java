import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private HashMap<Character, Integer> refTable;
    private HashMap<Integer, Character> reverseRefTable;

    public Solution () {
        this.refTable = new HashMap<>();
        this.reverseRefTable = new HashMap<>();
    }

    public void initializeTables() {
        // create reference table
        int index = 0;
        for (int i=65; i<=90; i++) {
            refTable.put((char) i, index);
            index++;
        }

        for (int i=48; i<=57; i++) {
            refTable.put((char) i, index);
            index++;
        }

        for (int i=40; i<=47; i++) {
            refTable.put((char) i, index);
            index++;
        }

        // create reverse reference table
        for (Character c : refTable.keySet()) {
            reverseRefTable.put(refTable.get(c), c);
        }
    }
    public String encode(String plainText) {
        List<Character> resultList = new ArrayList<>();
        char offSetChar = plainText.charAt(0);
        int offSetNum = refTable.get(offSetChar) - refTable.get('A');

        for (char c : plainText.substring(1).toCharArray()) {
            if (c == ' ') {
                resultList.add(c);
                continue;
            }

            int newCharIndex = (refTable.get(c) - offSetNum + 44) % 44;
            char newCharAfterOffSet = reverseRefTable.get(newCharIndex);
            resultList.add(newCharAfterOffSet);
        }

        String resultStr = resultList.stream().map(String::valueOf).collect(Collectors.joining());
        return plainText.substring(0, 1) + resultStr;
    }

    public String decode(String encodedText) {
        List<Character> resultList = new ArrayList<>();
        char offSetChar = encodedText.charAt(0);
        int offSetNum = refTable.get(offSetChar) - refTable.get('A');

        for (char c : encodedText.substring(1).toCharArray()) {
            if (c == ' ') {
                resultList.add(c);
                continue;
            }

            int newCharIndex = (refTable.get(c) + offSetNum + 44) % 44;
            char newCharAfterOffSet = reverseRefTable.get(newCharIndex);
            resultList.add(newCharAfterOffSet);
        }

        String resultStr = resultList.stream().map(String::valueOf).collect(Collectors.joining());
        return encodedText.substring(0, 1) + resultStr;
    }
}
