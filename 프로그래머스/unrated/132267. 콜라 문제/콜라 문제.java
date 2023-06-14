class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain=0;
        while(n>=a){
            int tmp = n/a*b;
            remain = n%a;
            answer+=tmp;
            n = tmp+remain;
        }
        return answer+n/a;
    }
}