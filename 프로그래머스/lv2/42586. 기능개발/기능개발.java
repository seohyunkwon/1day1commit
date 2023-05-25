import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        int max = (int)Math.ceil((100-progresses[0])/(double)speeds[0]);
        for(int i=1; i<speeds.length; i++){
            int n  = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            if(max>=n){
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                max=n;
            }            
        }
        if(cnt>0) list.add(cnt);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
