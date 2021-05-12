import java.util.*;
import java.lang.*;

public class CaesarCypher {

    public static String normalizeText(String newStr) {
        return newStr.replaceAll(" ","").replaceAll("\\p{Punct}","").toUpperCase();
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }

        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }

        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }

        return result;
    }

    public static String groupify(String grouped, int key) {
        if (grouped.length() % key != 0) {
            while(grouped.length() % key != 0)
            grouped += 'x';
        }

        int c = 1;
        String blockStr = "";
        for(int j = 0; j < grouped.length(); j++) {
            if (c++==key) {
                blockStr += " ";
                c = 1;
            } else {
                blockStr += grouped.charAt(j);
            }
        }

        return blockStr;
    }

    public static String encryptText(String encrypt, int key) {

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please provide line for crypto:");
        String newStr = input.nextLine();

        String nextStr = normalizeText(newStr);
        System.out.println(nextStr);

        System.out.println(groupify(nextStr, 5));
    }


}
