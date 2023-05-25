import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int[] arr =  map.values().stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int answer = 0;
        for(int i : arr) {
            k-=i; answer++;
            if(k<=0) break;
        }
        return answer;
    }
}