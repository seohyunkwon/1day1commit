import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i:scoville){
            pq.add(i);
        }
        
        while(true){
            long tmp1 = pq.poll();
            if(tmp1>=K) break;
            if(pq.isEmpty()) return -1;
            long tmp2 = pq.poll();
            pq.add(tmp1+(tmp2*2));
            answer++;
        }
        return answer;
    }
}