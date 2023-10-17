class Solution {
    public int solution(int n) {
        int[] answer = new int[n+1];
        for(int i=0; i<answer.length; i++){
            answer[i] = (i<3?i:(answer[i-1]+answer[i-2]))%1000000007;
        }
        return answer[n];
    }
}