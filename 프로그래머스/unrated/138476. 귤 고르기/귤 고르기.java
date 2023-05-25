import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = new int[10000000];
        for(int i:tangerine){
            arr[i-1] +=1;
        }
        Arrays.sort(arr);
        int j = arr.length-1;
        int answer = 0;
        while(k>0){
            k-=arr[j--]; answer++;
        }
        return answer;
    }
}