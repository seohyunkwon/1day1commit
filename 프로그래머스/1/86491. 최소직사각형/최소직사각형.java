class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int i=0; i<sizes.length; i++){
            int a = Math.min(sizes[i][0], sizes[i][1]);
            int b = Math.max(sizes[i][0], sizes[i][1]);
            w = Math.max(w, a);
            h = Math.max(h, b);
        }
        return w*h;
    }
}