class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i=1; i<brown; i++){
            for(int j=1; j<brown; j++){
                int x = i;
                int y = j;
                if(x*y-(x-2)*(y-2)==brown && (x-2)*(y-2)==yellow){
                    return new int[]{y,x};
                }
            }
            
        }
        return answer;
    }
}