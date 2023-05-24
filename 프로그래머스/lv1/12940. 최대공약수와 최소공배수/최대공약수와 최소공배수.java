class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {getGCD(n,m), getLCD(n,m)};
        return answer;
    }
    
    public int getGCD(int n, int m){
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        if(max%min==0) return min;
        return getGCD(min, max%min);
    }
    public int getLCD(int n, int m){
        return n*m/getGCD(n,m);
    }
    public static void main(String[] args){
        int[] arr =new Solution().solution(6,12);
        System.out.println(arr[0]+" "+arr[1]);
    }
}