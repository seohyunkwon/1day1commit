class Solution {
    public int[] solution(int n, int m) {
        return new int[]{getGCD(n, m), getLCM(n,m)};
    }
    
    private int getGCD(int n, int m){
        if(Math.max(n, m)%Math.min(n, m)==0) return Math.min(n, m);
        return getGCD(Math.min(n, m), Math.max(n, m)%Math.min(n, m));
    }
    
    private int getLCM(int n, int m){
        return n*m/getGCD(n,m);
    }
}