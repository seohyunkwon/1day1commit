import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer=0;
        Arrays.sort(citations);
        for(int n = 1 ; n<=citations.length; n++){
            int cnt = 0;
            for(int i=0; i<citations.length; i++){
                if(citations[i]>=n) cnt++;
            }
            if(cnt>=n && citations.length-cnt<=n) answer=n;
        }
        return answer;
    }
}