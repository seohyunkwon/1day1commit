class Solution {
    public int solution(int n) {
        int[] arr = new int[100001];
        arr[1] = 1;
        for(int i=2; i<arr.length; i++){
            arr[i] = (arr[i-2]+arr[i-1])%1234567;
            if(i==n) break;
        }
        return arr[n];
    }
}