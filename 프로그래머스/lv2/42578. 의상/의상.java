import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] s:clothes){
            map.put(s[1], map.getOrDefault(s[1], 1)+1);
        }
        int tmp = 0;
            for(String s:map.keySet()){          
            if(tmp==0){
                tmp = map.get(s);
            } else {
                tmp*=map.get(s);
            }
        }
        
        
        return tmp-1;
    }
}