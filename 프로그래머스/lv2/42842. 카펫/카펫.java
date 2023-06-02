class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i=1; i<=Math.sqrt(yellow); i++){
            int j = yellow/i;
            if(i*j!=yellow) continue;
            if(brown==(i+2)*2+(j+2)*2-4){
                return new int[]{Math.max(i+2, j+2),Math.min(i+2, j+2)};
            }
        }
        return answer;
    }
}