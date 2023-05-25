import java.util.*;
class Solution {
   public int[] solution(String s) {
            Map<Character, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                if(map.containsKey(c)) list.add(i-map.get(c));
                else list.add(-1);
                map.put(c, i);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
}