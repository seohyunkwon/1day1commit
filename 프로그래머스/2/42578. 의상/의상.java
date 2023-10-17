import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] tmp:clothes){
            map.put(tmp[1], map.getOrDefault(tmp[1],1)+1);
        }
        
        for(String s:map.keySet()){
            answer*=map.get(s);
        }
        
        return answer-1;
    }
}