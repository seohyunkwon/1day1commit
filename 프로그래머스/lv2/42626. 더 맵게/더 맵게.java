import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i:scoville){
            pq.offer(i);
        }
        int cnt = 0;
        while(true){
            if(pq.peek()>=K) break;
            if(pq.size()<2) {
                return -1;
            }
            cnt++;
            pq.offer(pq.poll()+pq.poll()*2);
        }
        return cnt;
    }
}