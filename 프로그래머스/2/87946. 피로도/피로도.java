class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        answer = backtracking(k, 0, dungeons, visited);
        return answer;
    }

    public int backtracking(int k, int depth, int[][] dungeons, boolean[] visited) {
        if (depth >= dungeons.length) {
            return 0;
        }

        int maxResult = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                int subResult = backtracking(k - dungeons[i][1], depth + 1, dungeons, visited);
                maxResult = Math.max(maxResult, subResult + 1);
                visited[i] = false; 
            }
        }
        return maxResult;
    }
}
