class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        long sum = 0;
        for(int i=0; i<a; i++){
            sum += days[i];
        }
        sum += b;
        return day[(int)(sum%7)];
    }
}