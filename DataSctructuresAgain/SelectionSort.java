public class SelectionSort {
    public static void main(String[] args) {

        int arr[] = { 64, 25, 12, 22, 11 };

        selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Iteration " + (i + 1) + " " + arr[i]);
        }

    }

    public static void selectionSort(int[] arr) {
        int min = 0;
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }
            }

        }
    }
}
