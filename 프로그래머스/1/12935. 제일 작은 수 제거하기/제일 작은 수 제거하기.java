import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        int i = 0;
        for(int j : arr){
            if(j == min) continue;
            answer[i] = j;
            i++;
        }
        return answer.length==0?new int[]{-1}:answer;
    }
}