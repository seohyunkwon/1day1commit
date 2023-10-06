class Solution {
    public int solution(int n) {
        int one = 0;
        String str = Integer.toBinaryString(n);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1') one++;
        }
        while(true){
            n++;
            int one2 = 0;
            str = Integer.toBinaryString(n);
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='1') one2++;
            }
            if(one==one2) return n;
        }
    }
}