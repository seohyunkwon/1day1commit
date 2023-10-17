import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            s = s.substring(1)+s.substring(0,1);
            if(isVaild(s)) answer++;
        }
        return answer;
    }

    public boolean isVaild(String s){
        boolean flag = true;
        Stack<String> stack = new Stack<>();
        for(String tmp:s.split("")){
            if(tmp.equals("{")||tmp.equals("[")||tmp.equals("(")){
                stack.add(tmp);
            } else if(tmp.equals("}")){
                if(!stack.isEmpty()&&stack.peek().equals("{")) stack.pop();
                else return false;
            } else if(tmp.equals("]")){
                if(!stack.isEmpty()&&stack.peek().equals("[")) stack.pop();
                else return false;
            } else if(tmp.equals(")")){
                if(!stack.isEmpty()&&stack.peek().equals("(")) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty()?true:false;
    }
}