import java.util.Iterator;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
            Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.push('(');
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                } else return false;
            }
        }
        
        if(stack.size()==0) return true;
        else return false;
         
 
    }
}