import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            sb.append(sb.substring(i,i+1));
            String tmp = sb.substring(i, sb.length()-1).toString();
            cnt += isCorrect(tmp);
        }
        return cnt;
    }
     public int isCorrect(String tmp){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<tmp.length(); i++){
            char c = tmp.charAt(i);
            switch (c){
                case '(': case '{' :  case '[' :
                    stack.push(c); break;
                case ')' : case '}' : case ']' :
                    if(stack.isEmpty() ||
                            (stack.peek()!='{' && c=='}') ||
                            (stack.peek()!='(' && c==')') ||
                            (stack.peek()!='[' && c==']')
                    ) return 0;
                    stack.pop(); break;
            }
        }
        return stack.isEmpty()?1:0;
    }
}