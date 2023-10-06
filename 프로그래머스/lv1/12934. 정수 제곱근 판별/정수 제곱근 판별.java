class Solution {
    public long solution(long n) {
        long m = (long)Math.sqrt(n);
        return m*m==n?(m+1)*(m+1):-1;
    }
}