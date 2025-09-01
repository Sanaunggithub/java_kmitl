import java.util.Iterator;
import pack.*;

public class Lab06_671725 {
    static void task_2() {
        MyQueueL_671725<String> queue = new MyQueueL_671725<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cantaloupe");
        System.out.print("standard for each: ");
        for (var item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("demo iterator");

        // Printing character which contains 'n'
        Iterator<String> iter = queue.iterator();
        char ch = 'n';
        while (iter.hasNext()) {
            String item = iter.next(); // moves to apple
            // indexOf returns -1 if not found the position
            if (item.indexOf(ch) != -1) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
static void task_3() { // compute InFix
    String inFix = "( 4 + 2 ) / 3 * ( 8 - 5 )";
    String postFix = MyShuntingYard.infixToPostfix(inFix);
    System.out.println("postFix= " + postFix);
    double ans = MyRPN.computeRPN(postFix);
    System.out.println("Result " + ans); 
}
    public static void main(String[] args) {
        // task_2();
        task_3();
    }
}