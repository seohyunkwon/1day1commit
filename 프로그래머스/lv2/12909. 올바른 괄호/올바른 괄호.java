import java.util.Iterator;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        try{
            Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.push('(');
            else stack.pop();
        }
        
        if(stack.size()==0) return true;
        else return false;
        } catch (Exception e){
            return false;
        }
 
    }
}