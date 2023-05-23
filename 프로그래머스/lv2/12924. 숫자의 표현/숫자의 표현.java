class Solution {
    public int solution(int n) {
        int answer = 1; int sum = 1;
        int start = 1; int end = 1;
        while(end<n && start<n){
            if(sum<n){
                end++; sum+=end;
            } else if(sum>n){
                start++; sum-=start;
                end--; sum-=end;
            } else {
                answer++;
                start++; sum-=start;
                end--; sum-=end;
            }
        }
        return answer;
    }
}