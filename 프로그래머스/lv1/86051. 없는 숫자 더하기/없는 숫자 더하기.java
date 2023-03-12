class Solution {
    public int solution(int[] numbers) {
    	int[] list = new int[10];
        for(int i:numbers) {
        	list[i] +=1;
        }
        int sum = 0;
        for(int i=0; i<10; i++) {
        	if(list[i]==0) {
        		sum+=i;
        	}
        }
        if(sum==0) return -1;
        return sum;
    }
}