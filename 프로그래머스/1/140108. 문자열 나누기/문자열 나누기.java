class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xnum = 0;
        int ynum = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==x) xnum++;
            else ynum++;
            if(xnum==ynum){
                answer++;
                xnum=0; ynum=0;
                if(s.length()-1==i) break;
                x=s.charAt(i+1);
            }
        }
        return xnum!=ynum?answer+1:answer;
    }
}