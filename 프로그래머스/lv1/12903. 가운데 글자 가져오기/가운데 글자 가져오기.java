class Solution {
    public String solution(String s) {
        int n = s.length()/2;
        if(s.length()%2==0){
            return s.charAt(n-1)+""+s.charAt(n);
        } else {
            return s.charAt(n)+"";
        }
    }
}