import java.lang.reflect.Array;
import java.util.*;

public class LinkedList_ArrayList {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        // Linked List

        startTime = System.nanoTime();

        // linkedList.get(999999);
        linkedList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;
        System.out.println("Linked List Elapsed Time: " + elapsedTime + " ns");

        // Array List

        startTime = System.nanoTime();

        arrayList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;
        System.out.println("Array List Elapsed Time: " + elapsedTime + " ns");

    }
}
