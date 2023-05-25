class Solution {
    public int solution(int[] nums) {
        boolean[] arr = new boolean[10001];
        for(int i=2; i<arr.length; i++){
            if(arr[i]) continue;
            for(int j=i*2; j<arr.length; j+=i){
                arr[j] = true;
            }
            arr[i] = false;
        }
        int cnt = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(!arr[nums[i]+nums[j]+nums[k]]) cnt++;
                }
            }
        }
        return cnt;
    }
}