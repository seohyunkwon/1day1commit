class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int max = n<<1;
        for(int i=n+1; i<=max; i++){
            int tmp = Integer.bitCount(i);
            if(tmp==cnt) return i;
        }
        return 0;
    }
}