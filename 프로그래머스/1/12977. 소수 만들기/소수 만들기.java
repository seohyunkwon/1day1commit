class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] arr = new boolean[3001];
        for(int i=2; i<arr.length; i++){
            if(arr[i]) continue;
            for(int j = i*2; j<arr.length; j+=i){
                arr[j] = true;
            }
        }
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int tmp = nums[i]+nums[j]+nums[k];
                    if(!arr[tmp]) answer++;
                }
            }
        }
        
        return answer;
    }
}