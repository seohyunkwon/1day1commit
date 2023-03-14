class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){
        int[] answer = {-1};
        return answer;}
        int min = arr[0];
        for(int i:arr){
            min = min>i?i:min;
        }
        int[] answer = new int[arr.length-1];
        int k=0;
        for(int i:arr){
            if(i!=min) {
                answer[k++]=i;
            }
        }
        return answer;
    }
}