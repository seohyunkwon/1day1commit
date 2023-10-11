class Solution {
    public int solution(int left, int right) {
        int[] arr = new int[10001];
        for(int i=1; i<arr.length; i++){
            int cnt = 0;
            for(int j=1; j<i; j++){
                if(i%j==0) cnt++;
            }
            arr[i] = cnt;
        }
        
        int answer = 0;
        for(int i=left; i<=right; i++){
            answer+=arr[i]%2!=0?i:-1*i;    
        }
        
        return answer;
    }
}