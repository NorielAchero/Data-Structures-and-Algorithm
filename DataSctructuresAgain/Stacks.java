import java.util.*;

public class Stacks {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());

        System.out.println(stack);
        System.out.println(stack.empty());

        System.out.println(stack.search("utuy"));

        // .push
        // .pop
        // .peek
        // .empty Checks the stack is empty or not
        // .search Searches the element in the stack and returns the position of the
        // element from the top of the stack

    }
}