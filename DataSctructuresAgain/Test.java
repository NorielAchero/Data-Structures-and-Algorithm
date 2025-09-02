import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // String s = "";
        // String[] words = new String[4];

        String s = "dsahjpjauf";
        String[] words = { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" };

        Integer ctrl = 0;

        // System.out.print("Input string S: ");
        // s = scanner.nextLine();

        // System.out.print("Input words: ");
        // for (int i = 0; i < words.length; i++) {
        // words[i] = scanner.nextLine();
        // }

        for (int i = 0; i < words.length; i++) {
            if (isSubsequence(words[i], s)) {
                ctrl++;
            }
        }

        System.out.println("There are " + ctrl + " matching subsequences.");
    }

    // public static boolean isSubsequence(String s, String t) {

    // Integer ctrl = 0;

    // for (int i = 0; i < t.length(); i++) {
    // for (int j = 0; j < s.length(); j++) {
    // if (t.charAt(i) == s.charAt(j)) {
    // System.out.println(t.charAt(i) + " " + s.charAt(j));
    // ctrl++;
    // break;
    // }
    // }
    // System.out.println("---" + t.charAt(i) + "---" + i);
    // System.out.println();
    // }

    // if (ctrl == s.length()) {
    // return true;
    // } else {
    // return false;
    // }

    // }

    public static boolean isSubsequence(String sub, String main) {
        int i = 0, j = 0;

        while (i < sub.length() && j < main.length()) {
            if (sub.charAt(i) == main.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sub.length();
    }

}