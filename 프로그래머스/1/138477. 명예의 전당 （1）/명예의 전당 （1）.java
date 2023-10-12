import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i:score){
            if(queue.size()==k) {
                int tmp = queue.poll();
                if(tmp<i) {
                    queue.add(i);
                } else {
                    queue.add(tmp);
                }
            } else {
                queue.add(i);      
            }
            int tmp2 = queue.poll();
            list.add(tmp2);
            queue.add(tmp2);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}