class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int j=0; j<a.length; j++) {
            answer += a[j]* b[j];
        	
        }
        return answer;
    }
}