import java.util.Scanner;

public class Main {

    public static boolean parenthesesCheck(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static String reverseInteger(int n) {
        return new StringBuilder(Integer.toString(n)).reverse().toString();
    }

    public static String encryptThis(String input) {
        String[] words = input.split(" ");
        StringBuilder encrypted = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                encrypted.append(encryptWord(word)).append(" ");
            }
        }
        return encrypted.toString().trim();
    }

    private static String encryptWord(String word) {
        if (word.length() == 0) return "";
        if (word.length() == 1) return Integer.toString((int) word.charAt(0));

        char firstCharCode = word.charAt(0);
        char[] letters = word.toCharArray();
        char temp = letters[1];
        letters[1] = letters[letters.length - 1];
        letters[letters.length - 1] = temp;

        return ((int) firstCharCode) + new String(letters, 1, letters.length - 1);
    }

    public static String decipherThis(String input) {
        String[] words = input.split(" ");
        StringBuilder decrypted = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                decrypted.append(decipherWord(word)).append(" ");
            }
        }
        return decrypted.toString().trim();
    }

    private static String decipherWord(String word) {
        int i = 0;
        while (i < word.length() && Character.isDigit(word.charAt(i))) i++;
        int code = Integer.parseInt(word.substring(0, i));
        char firstChar = (char) code;

        if (i >= word.length()) return Character.toString(firstChar);

        char[] letters = word.substring(i).toCharArray();
        if (letters.length > 1) {
            char temp = letters[0];
            letters[0] = letters[letters.length - 1];
            letters[letters.length - 1] = temp;
        }

        return firstChar + new String(letters);
    }

    public static void main(String[] args) {
        System.out.println(parenthesesCheck("()"));
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(parenthesesCheck("(())((()())())"));
        System.out.println(reverseInteger(1234));
        System.out.println(encryptThis("Hello good day"));
        System.out.println(decipherThis("72olle 103doo 100ya"));
    }
}
