import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[] arr = new int[triangle[triangle.length-1].length];
        for(int i=1; i<triangle.length; i++){
            int[] tmp = triangle[i];
            int[] prev = triangle[i-1];
            for(int j=0; j<tmp.length; j++){
                int a = j-1>=0?triangle[i-1][j-1]:0;
                int b = j<triangle[i-1].length?triangle[i-1][j]:0;
                tmp[j] += Math.max(a,b);
            }
        }
        for(int tmp:triangle[triangle.length-1]){
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}