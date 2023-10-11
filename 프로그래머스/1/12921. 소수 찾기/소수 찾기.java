class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[1000001];
        for(int i=2; i<arr.length; i++){
            if(arr[i]) continue;
            for(int j=i*2; j<arr.length; j+=i){
                arr[j] = true;
            }
        }
        for(int i=2; i<=n; i++){
            if(!arr[i]) answer++;
        }
        return answer;
    }
}