import pack.MyStack_671725;

public class Solution_671725 {
    
    public static boolean backspaceCompare(String s, String t){
        MyStack_671725<Character> stack1 = new MyStack_671725<Character>();
        MyStack_671725<Character> stack2 = new MyStack_671725<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                stack1.pop();
            } else {
                stack1.push(s.charAt(i));
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                stack1.pop();
            } else {
                stack1.push(t.charAt(i));
            }
        }   

        if (stack1.size() != stack2.size()) {
            return false;
        }

        // Compare stack
        for (int i = 0; i < stack1.size(); i++) {
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }
    
        return true;
    }
    
    
}
