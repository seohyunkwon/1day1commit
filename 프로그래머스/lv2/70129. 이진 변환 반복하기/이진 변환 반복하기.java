class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while(true){
            cnt++;
            int n = s.replaceAll("0","").length();
            zero += s.length()-n;
            s = Integer.toBinaryString(n);
            if(s.equals("1")) break;
        } 
        
        return new int[]{cnt, zero};
    }
}