import java.util.*;

public class Queues {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.isEmpty();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println(queue.size());

        System.out.println(queue.contains("D"));

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue);

        // .offer() -> adds an element to the end of the queue
        // .poll() -> removes the element from the front of the queue
        // .peek() -> returns the front element of the queue without removing it
        // .isEmpty() -> checks if the queue is empty
        // .size() -> returns the size of the queue
        // .contains() -> checks if the queue contains a specific element

    }

}
