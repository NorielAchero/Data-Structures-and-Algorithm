
public class ArrProcessing {
    public static void main(String[] args) {

        Integer[] arr = { 10, 5, 20, 8, 12 };

        System.out.println(arrayProcessing(arr));
        ;

    }

    public static int arrayProcessing(Integer[] arr) {
        int highest = 0;
        int secondHighest = 0;
        int indexCtrl = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
                indexCtrl = i;
            }
        }
        arr[indexCtrl] = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondHighest) {
                secondHighest = arr[i];
                indexCtrl = i;
            }
        }

        return secondHighest;
    }
}
