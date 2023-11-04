import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> waiting = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            waiting.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        while(!waiting.isEmpty()){
            int[] tmp = waiting.poll();
            int m = pq.peek();
            if(tmp[1]!=m){
                waiting.add(tmp);
                continue;
            } 
            pq.poll();
            answer++;
            if(tmp[0]==location){
                break;
            }
        }
        return answer;
    }
}