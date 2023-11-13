class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int j=0;
        while(sb.length()<m*t){
            sb.append(Integer.toString(j++,n));
        }
        String numbers = sb.toString();
        sb = new StringBuilder();
        int idx = p-1;
        while(sb.length()!=t){
            sb.append(numbers.charAt(idx));
            idx+=m;
        }
        return sb.toString().toUpperCase();
    }
}