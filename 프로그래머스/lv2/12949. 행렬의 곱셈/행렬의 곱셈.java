import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                int sum = 0;
                int[] tmp = new int[arr1[0].length];
                for(int k=0; k<arr1[0].length; k++){
                    tmp[k]=arr1[i][k];
                }
                for(int k=0; k<arr2.length; k++){
                    sum+=tmp[k]*arr2[k][j];
                }
                answer[i][j]=sum;
            }
        }
        return answer;
    }
}

    