import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            String s = keymap[i];
            for(int j=0; j<s.length(); j++){
                char c = keymap[i].charAt(j);
                if(!map.containsKey(c)){
                    map.put(c, j+1);   
                } else {
                    int tmp = map.get(c);
                    if(j+1<tmp) map.put(c, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            String s = targets[i];
            for(int j=0; j<s.length(); j++){
                if(!map.containsKey(s.charAt(j))) {
                    answer[i] = -1; break;
                }
                answer[i] += map.getOrDefault(s.charAt(j), 0);
            }
        }
        
        return answer;
    }
}