import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        for(int i=0; i<=max; i++){
            int cnt = 0;
            for(int j:citations){
                if(j>=i) cnt++;
            }
            if(cnt>=i && citations.length-cnt<=i){
                answer = Math.max(i,answer);
            }
        }
        return answer;
    }
}