import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        PriorityQueue<Integer> pqX = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqY = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] arr : sizes){
            pqX.offer(Math.max(arr[0],arr[1]));
            pqY.offer(Math.min(arr[0],arr[1]));
        }

        return pqX.poll()*pqY.poll();
    }

}