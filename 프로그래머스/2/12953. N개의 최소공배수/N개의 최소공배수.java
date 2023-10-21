import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        for(int i=0; i<arr.length-1; i++){
            int lcm  = getLCM(arr[i], arr[i+1]);
            arr[i+1] = lcm;
        }
        return arr[arr.length-1];
    }

    public int getGCD(int n, int m){
        if(m%n==0) return n;
        return getGCD(Math.min(n, m%n), Math.max(n, m%n));
    }
    
    public int getLCM(int n, int m){
        return n*m/getGCD(n,m);
    }
}