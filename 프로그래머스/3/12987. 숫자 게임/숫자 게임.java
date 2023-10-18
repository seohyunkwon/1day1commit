import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = -1;
        boolean[] visited = new boolean[B.length];
        loop : 
        for(int i=0; i<A.length; i++){
            for(int j=idx+1; j<B.length; j++){
                if(A[i]<B[j]&&!visited[j]) {
                    visited[j] = true;
                    idx = j;
                    answer++;
                    continue loop;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}