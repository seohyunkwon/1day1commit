import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> result = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            result.put(want[i], number[i]);
        }
        
        Map<String, Integer> cur = new HashMap<>();
        
        for(int i = 0; i < 10; i++) {
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
        }
                
        for(int i = 0; i < discount.length - 9; i++) {
            
            if(i > 0) { 
                cur.put(discount[i - 1], cur.get(discount[i - 1]) - 1);
                cur.put(discount[i + 9], cur.getOrDefault(discount[i + 9], 0) + 1);
            }
            
            if(check(result, cur)) answer++;
        }
        return answer;
    }
    
    public boolean check(Map<String, Integer> result, Map<String, Integer> cur) {
        for(String str : result.keySet()) {
            if(!cur.containsKey(str) || cur.get(str) < result.get(str)) 
                return false; 
        }
        return true;
    }
}