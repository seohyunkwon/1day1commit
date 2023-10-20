import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if(n>s) return new int[]{-1};
        int[] answer = new int[n];
        int m = s%n;
        int idx = m>0?n-m:n+1;
        for(int i=0; i<answer.length; i++){
            answer[i] = s/n+(i>=idx?1:0);
        }
        return answer;
    }
}