import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            if(deque.isEmpty()) deque.add(arr[i]);
            else if(deque.peekLast()!=arr[i]) {
                deque.add(arr[i]);
            }
        }
        int[] answer = new int[deque.size()];
        int i = 0;
        while(!deque.isEmpty()){
            answer[i++] = deque.pollFirst();
        }
        return answer;
    }
}