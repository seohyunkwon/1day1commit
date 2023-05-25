import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            if(pq.size()<k){
                pq.add(score[i]);
            } else {
                int n = pq.poll();
                pq.offer((int)Math.max(n, score[i]));
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}