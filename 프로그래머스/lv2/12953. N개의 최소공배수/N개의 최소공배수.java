import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            arr[i+1]=getLCM(arr[i],arr[i+1]);
        }
        return arr[arr.length-1];
    }
    public int getGCD(int a, int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(min==1) return 1;
        if(max%min==0) return min;
        return getGCD(min, max%min);
    }
    public int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
}