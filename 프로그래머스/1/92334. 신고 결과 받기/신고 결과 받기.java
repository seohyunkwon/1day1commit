import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> count = new HashMap<>(); 
        HashMap<String, Set<String>> reported = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        for(String s:id_list){
            reported.put(s, new HashSet<>());
        }
        for(String s:report){
            String[] tmp = s.split(" ");
            if(reported.get(tmp[1]).contains(tmp[0])) continue;
            reported.get(tmp[1]).add(tmp[0]);
            count.put(tmp[1], count.getOrDefault(tmp[1], 0)+1);
        }
        for(String s:id_list){
            if(count.getOrDefault(s,0)<k) continue;
            Set<String> tmp = reported.get(s);
            if(tmp.size()==0) continue;
            for(String s2:tmp){
                result.put(s2, result.getOrDefault(s2, 0)+1);
            }
        }
        for(int i=0; i<id_list.length; i++){
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}