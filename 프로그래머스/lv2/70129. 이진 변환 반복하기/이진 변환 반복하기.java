class Solution {
    public int[] solution(String s) {
        int times = 0;
        int cnt = 0;
        while(!s.equals("1")){
            times++;
            String tmp = s.replaceAll("0", "");
            cnt+= s.length()-tmp.length();
            s = Integer.toBinaryString(tmp.length());
        }
        return new int[]{times, cnt};
    }
}