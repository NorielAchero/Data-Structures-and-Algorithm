public class Recursion {
    public static void main(String[] args) {

        walk(5);

    }

    public static void walk(int steps) {

        if (steps < 1) {
            System.out.println("You have reached home");
        } else {
            System.out.println("You took a step");
            walk(steps - 1);
        }
    }
}
