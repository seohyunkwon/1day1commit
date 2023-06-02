import java.util.Stack;

class Solution{
    public int solution(String s){
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        for(String tmp:arr){
            if(stack.isEmpty()){
                stack.push(tmp);
            } else {
                if(stack.peek().equals(tmp)){
                    stack.pop();   
                } else {
                    stack.push(tmp);
                }
            }
        }
        
        return stack.isEmpty()?1:0;
    }
}