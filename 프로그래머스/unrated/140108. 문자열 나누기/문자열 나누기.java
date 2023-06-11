class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        while(idx<s.length()){
            char x = s.charAt(idx++);
            int xcnt = 1;
            int ycnt = 0;
            while(xcnt!=ycnt){
                if(idx>=s.length()) break;
                char tmp = s.charAt(idx++);
                if(tmp==x) xcnt++;
                else ycnt++;
            }
            answer++;
        }
        return answer;
    }
}