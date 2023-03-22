class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        while(n>0){
            s+=n%3;
            n/=3;
        }
        int j=0;
        for(int i=s.length()-1; i>=0; i--){
            answer+=(s.charAt(i)-'0')*Math.pow(3,j++);
        }
        return answer;
    }
}
