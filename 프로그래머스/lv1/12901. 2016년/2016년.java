class Solution {
    public String solution(int a, int b) {
        int[] date = {31, 31, 29, 31, 30 , 31, 30, 31, 31, 30, 31, 30};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] first_day = new int[12];
        first_day[0] = 5;
        for(int i=1; i<date.length; i++){
            first_day[i] = (date[i]+first_day[i-1])%7;
        }
        int result = (b+first_day[a-1]-1)%7;
        return day[result];
    }
}