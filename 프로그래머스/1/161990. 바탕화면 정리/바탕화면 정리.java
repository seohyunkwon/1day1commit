class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE; int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE; int rdy = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++){
            String s = wallpaper[i];
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if(c=='#') {
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j);
                    lux = Math.min(lux, i);
                    rdx = Math.max(rdx, i);
                } 
            }
        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}