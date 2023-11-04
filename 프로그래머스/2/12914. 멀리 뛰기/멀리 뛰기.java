class Solution {
    public long solution(int n) {
        long[] dp = new long[2000];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<dp.length; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n-1]%1234567;
    }
}