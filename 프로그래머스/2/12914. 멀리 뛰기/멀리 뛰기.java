class Solution {
    public long solution(int n) {
        long answer[] = new long[n + 1];
        if(n <= 2) return n;
        for(int i = 1; i < n + 1; i++) {
            if(i <= 2) answer[i] = i;
            else answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }
        return answer[n];
    }
}