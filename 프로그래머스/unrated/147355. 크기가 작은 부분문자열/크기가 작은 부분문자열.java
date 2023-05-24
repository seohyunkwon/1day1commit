class Solution {
    public int solution(String t, String p) {
        int start = 0;  int len = p.length();
        int cnt = 0;
        long n = Long.parseLong(p);
        while(true){
            String tmp = t.substring(start, start+len);
            if(Long.parseLong(tmp)<=n) cnt++;
            start++;
            if(start+len>t.length()) break;
        }
        return cnt;
    }
}