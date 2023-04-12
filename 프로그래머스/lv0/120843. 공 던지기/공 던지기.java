import java.util.*;
class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i:numbers){
            q.add(i);
        }
        for(int i=1; i<k; i++){
            q.add(q.poll());
            q.add(q.poll());
        }
        return q.peek();
    }
}