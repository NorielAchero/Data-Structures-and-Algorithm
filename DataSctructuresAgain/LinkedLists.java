import java.util.*;

public class LinkedLists {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.offer("A");
        list.offer("B");
        list.offer("C");
        list.offer("D");
        list.offer("E");
        list.offer("F");

        list.add(4, "X");
        list.remove("D");

        list.addFirst("asd");
        list.addLast("zxc");

        System.out.println(list.peekFirst() + " " + list.peekLast());

        System.out.println(list);

    }
}
