import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            queue.add(new int[]{i,priorities[i]});
            numbers.add(priorities[i]);
        }
        int n = numbers.poll();
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            System.out.println(tmp[0]+" "+tmp[1]);
            if(tmp[1]==n){
                answer++;
                if(tmp[0]==location) break;
                n = numbers.poll();
            } else {
                queue.add(tmp);
            }
        }

        return answer;
    }
}