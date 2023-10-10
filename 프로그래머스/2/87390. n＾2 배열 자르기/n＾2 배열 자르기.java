import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left)+1;
        int[] answer = new int[len];
        long hx = left/n;
        long hy = right/n;
        long wx = left%n;
        long wy = right%n;
        int x = 0;
        System.out.println(hx+" "+hy+" "+wx+" "+wy);
        for(long i=hx; i<=hy; i++){
            for(int j=0; j<n; j++){
                if(i==hx&&j<wx) continue;
                if(i==hy&&j>wy) continue;
                answer[x++] = Math.max((int)i,j)+1;
            }
        }
        return answer;
    }
}