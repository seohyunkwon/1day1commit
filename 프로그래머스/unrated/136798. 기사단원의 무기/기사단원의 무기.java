class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int j = getPrimeNum(i);
            if(j>limit) answer+=power;
            else answer+=j;
        }
        return answer;
    }
    
    public int getPrimeNum(int n){
        int m = (int)Math.sqrt(n);
        int cnt = 0;
        for(int i=1; i<=m; i++){
            if(n%i==0) cnt++;
        }
        return cnt*2+(m*m==n?-1:0);
    }
}