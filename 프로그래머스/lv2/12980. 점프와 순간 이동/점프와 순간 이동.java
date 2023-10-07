import java.util.*;
public class Solution {
    public int solution(int n) {
        int tmp = 0;
        while(n>=2){
            tmp+=n%2;
            n = n/2;
        }
        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            if(i%2==0){
                arr[i] = arr[i/2];
            } else {
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[n]+tmp;
    }
}