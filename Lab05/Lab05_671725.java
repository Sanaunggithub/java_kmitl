import java.util.StringTokenizer;
import pack.MyStack_671725;
import pack.MyRPN;


public class Lab05_671725 {
    static void demo_0() {
        MyStack_671725<Integer> stack = new MyStack_671725<>();
        for (int i = 1; i < 4; i++)
            stack.push(i);
        System.out.println(stack);
    }
    static void demo_1() {
        String toBeRPN = "8 5 - 4 2 + 3 / *";
        StringTokenizer st = new StringTokenizer(toBeRPN);
        int i = 0;
        String t = "";
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            if (MyRPN.isNumeric(t))
                System.out.println("Token " + i++ + " = " + t);
            else   
                System.out.println("Token " + i++ + " = " + t + " is an operator");
        }
    }
    static void demo_2() {
        String postfixString = "8 5 - 4 2 + 3 / *";
        System.out.println(postfixString + " = " + MyRPN.computeRPN(postfixString));
    }
    static void demo_3(){
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(Solution_671725.backspaceCompare(s, t));
    }
    public static void main(String[] args) {
        demo_0();
        demo_1();
        demo_2();
        demo_3();
    }
}