import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;
        int times = w*2+1;
        for(int i=0; i<stations.length; i++){
            int tmp = stations[i];
            if(tmp<=idx) {
                idx = tmp+w+1; continue;
            }
            answer+= (tmp-idx-w)/times+((tmp-idx-w)%times>0?1:0);
            idx = tmp+w+1;
        }
        if(--idx<n) answer+=(n-idx)/times+((n-idx)%times>0?1:0);
        return answer;
    }
}
