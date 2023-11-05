class Solution {
    public int solution(int[] numbers, int target) {
        return findTarget(numbers, 0, target, 0);
    }
    
    public int findTarget(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int cnt = 0;
        cnt += findTarget(numbers, depth + 1, target, sum + numbers[depth]);
        cnt += findTarget(numbers, depth + 1, target, sum - numbers[depth]);

        return cnt;
    }
}
