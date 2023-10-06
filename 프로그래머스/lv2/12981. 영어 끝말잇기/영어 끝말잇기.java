import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int cnt = 1;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<words.length; i++){
            String str = words[i];
            if(stack.contains(str)){
                return new int[]{(i+1)%n==0?n:(i+1)%n, (i+1)/n+((i+1)%n!=0?1:0)};
            } else {
                if(!stack.isEmpty()){
                    String tmp = stack.peek();
                    if(tmp.charAt(tmp.length()-1)!=str.charAt(0)) 
                    return new int[]{(i+1)%n==0?n:(i+1)%n, (i+1)/n+((i+1)%n!=0?1:0)};
                }
                stack.push(str);
            }
        }
        return new int[]{0,0};
    }
}