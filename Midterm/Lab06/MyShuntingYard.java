import java.util.Stack;
import pack.MyQueueL_671725;

public class MyShuntingYard {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueL_671725<String> output = new MyQueueL_671725<>();
        Stack<String> operator = new Stack<>();

        String[] tokens = infixString.split(" ");   

        for (String token : tokens) {
            if(token.matches("\\d+")){
                output.enqueue(token);
            }
            else if(token.equals("(")){
                operator.push(token);
            }

            else if(token.equals(")")){    
                while (!operator.isEmpty() && !operator.peek().equals("(")) {
                    output.enqueue(operator.pop());
                }
                if (!operator.isEmpty()) {
                    operator.pop(); // discard "("
                }         
            }

            else{
                // use while cuz there might be multiple operators on stack with higher precendence
                while (!operator.isEmpty() && order(operator.peek()) >= order(token)) {
                    output.enqueue(operator.pop());
                }
                operator.push(token);
            }
            }

        // sending all operators to the output
        while(!operator.isEmpty()){
            output.enqueue(operator.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (String t : output) {
            sb.append(t).append(" ");
        }

        return sb.toString().trim();
        }
}
