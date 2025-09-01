package pack;

import java.util.regex.Pattern;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
    /* your code */
    MyStack_671725<Double> stack = new MyStack_671725<Double>();
    
    String[] tokens = rpn.split(" ");
    
    for (String token: tokens){
        if (isNumeric(token)) {
            stack.push(Double.parseDouble(token));
        }

        else {
            double b = stack.pop();
            double a = stack.pop();

            if (token.equals("+")) {
                stack.push(a + b);
            } else if (token.equals("-")){
                stack.push(a - b);
            } else if (token.equals("*")){
                stack.push(a * b);
            } else if (token.equals("/")) {
                if(b == 0){
                    System.out.println("cannot be zero");
                }
                else{
                    stack.push( a / b);
                }
                
            }
        }
    }
    return stack.pop();// final result
    }
}
