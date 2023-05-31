import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int n = score.length/m;
        int[] arr = new int[k];
        for(int i:score){
            arr[i-1]+=1;
        }
        int answer = 0;
        int tmp = m;
        System.out.println(Arrays.toString(arr));
        for(int i=k-1; i>=0; i--){
            while(arr[i]-tmp>=0){
                answer+=(i+1)*m;
                arr[i] -= tmp;
                tmp = m;

            }
            tmp-=arr[i];
            System.out.println(i+1+" "+arr[i]);
        }
        return answer;
    }
}