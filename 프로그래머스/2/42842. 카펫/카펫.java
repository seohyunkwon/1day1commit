class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i = 1; i <= (int)Math.sqrt(yellow); i++) {
            if(yellow % i != 0) continue;
            
            int count = (i + 2) * 2 + (yellow / i) * 2;
            
            if(count == brown) {
                return new int[]{(yellow / i) + 2, i + 2};
            }
        }
        
        return answer;
    }
}