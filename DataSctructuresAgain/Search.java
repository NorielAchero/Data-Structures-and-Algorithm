public class Search {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int target = 7;

        int result = linearSearch(arr, target);

        System.out.println(result);
    }

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;

    }
}
