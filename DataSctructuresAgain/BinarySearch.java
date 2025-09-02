import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int target = 13;

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println(target + " is at the " + index);
        } else {
            System.out.println("Not found");
        }

    }

    private static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = arr[mid];

            if (value < target) {
                start = mid + 1;
            } else if (value > target) {
                end = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

}
