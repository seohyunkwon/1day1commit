import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for(String s : discount){
            stack.push(s);
        }
        
        for(int i=0; i<discount.length; i++){
            HashMap<String, Integer> cart = new HashMap<>();
            for(int j=i; j<i+10; j++){
                if(j>discount.length-1) break;
                cart.put(discount[j], cart.getOrDefault(discount[j],0)+1);
            }
            boolean flag = true;
            for(int j=0; j<want.length; j++){
                if(cart.getOrDefault(want[j],0)!=number[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}