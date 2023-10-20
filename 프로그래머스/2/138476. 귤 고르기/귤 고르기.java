import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i:map.keySet()){
            pq.add(new int[]{i, map.get(i)});
        }
        while(k>0){
            int[] tmp = pq.poll();
            k -= tmp[1];
            answer++;
        }
        return answer;
    }
}