import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] tre = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1 = 0; int score2 = 0; int score3 = 0;
        for(int i=0; i<answers.length; i++){
            score1 += one[i%5]==answers[i]?1:0;
            score2 += two[i%8]==answers[i]?1:0;
            score3 += tre[i%10]==answers[i]?1:0;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if(max==score1) queue.add(1);
        if(max==score2) queue.add(2);
        if(max==score3) queue.add(3);
        int[] answer = new int[queue.size()];
        int i=0;
        while(!queue.isEmpty()){
            answer[i++] = queue.poll();
        }
        return answer;
    }
}