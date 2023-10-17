class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Integer.toString(n,k).split("0");
        for(int i=0; i<str.length; i++){
            if(str[i].length()<1) continue;
            if(isPrime(Long.parseLong(str[i]))) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n==1) return false;
        boolean flag = true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}