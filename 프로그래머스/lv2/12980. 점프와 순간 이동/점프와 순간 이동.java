public class Solution {
    public int solution(int n) {
        int ans = 1;

        while(n>2){
            if(n%2==1){
                n--;
                ans++;
            } else {
                n /= 2;
            }
        }

        return ans;
    }
}