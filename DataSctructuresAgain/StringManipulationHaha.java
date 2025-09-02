import java.util.*;

public class StringManipulationHaha {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s1 = "apple";
        String s2 = "papel";

        System.out.println(isAnagrams(s1.toLowerCase(), s2.toLowerCase()));

    }

    public static boolean isAnagrams(String s1, String s2) {

        if (s1.length() == s2.length()) {
            char[] s1array = s1.toCharArray();
            char[] s2array = s2.toCharArray();

            Arrays.sort(s1array);
            Arrays.sort(s2array);

            int ctrl = 0;

            for (int i = 0; i < s1array.length; i++) {
                if (s1array[i] == s2array[i]) {
                    ctrl++;
                }
            }

            if (ctrl == s1array.length) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}
