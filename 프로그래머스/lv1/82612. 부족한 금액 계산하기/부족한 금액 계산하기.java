class Solution {
    public long solution(int price, int money, int count) {
        long sum = (long)count*(count+1)/2*(long)price;
        return money-sum>0?0:sum-money;
    }
}
