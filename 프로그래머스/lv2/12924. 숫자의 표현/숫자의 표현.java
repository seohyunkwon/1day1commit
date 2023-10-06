class Solution {
    public int solution(int n) {
        int start = 0;
        int end = 1;
        int sum = 1;
        int answer = 1;
        while(start<end){
            if(end>=n) break;
            if(sum<n){
                end++; sum+=end;
            } else if(sum>n){
                sum-=start; start++;
            } else{
                answer++;
                end++; sum+=end;
            }
        }
        return answer;
    }
}