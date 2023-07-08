import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]>=numbers.length) break;
            
            int a = tmp[1]+numbers[tmp[0]];
            int b = tmp[1]-numbers[tmp[0]];
            
            if((b==target || a == target) && tmp[0]==numbers.length-1) {
                sum++;
                continue;
            }
            
            if(visited[tmp[0]]) continue;
            queue.add(new int[]{tmp[0]+1, a});
            queue.add(new int[]{tmp[0]+1, b});
        }
        return sum;
    }
}