class Solution {
    public int solution(int n) {
        boolean[] arr = new boolean[n+1];
        int cnt = 0;
        for(int i=2; i<=n; i++){
            if(!arr[i]){
                cnt++;
                for(int j=i*2; j<=n; j+=i){
                    if(!arr[j]){
                    arr[j] = true;
                    }
                }
            }
            
        }
        return cnt;
    }
}