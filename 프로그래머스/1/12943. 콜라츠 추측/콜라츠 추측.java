class Solution {
    public int solution(int num) {
        int count = 0;
        long num2 = num;
        while(num2!=1){
            if(count>500) break;
            if(num2%2==0){
                num2 = num2/2;
            } else {
                num2 = num2*3+1;
            }
            count++;
        }
        return count<501?count:-1;
    }
}