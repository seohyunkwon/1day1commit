import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:works){
            pq.add(i);
        }
        while(n>0){
            int tmp = pq.poll()-1;
            pq.add(tmp>0?tmp:0);
            n--;
        }
        for(int i : pq){
            answer += i*i;
        }
        return answer;
    }
}