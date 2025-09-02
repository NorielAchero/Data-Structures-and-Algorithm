import java.util.*;

public class PriorityQueues {
    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("F");
        queue.offer("B");
        queue.offer("D");
        queue.offer("A");
        queue.offer("E");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
