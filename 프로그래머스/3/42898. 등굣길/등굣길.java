class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n + 1][m + 1];
        for(int[] tmp : puddles) {
            map[tmp[0]][tmp[1]] = -1;
        }
        
        map[1][1] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                boolean flag = false;
                if(i + 1 < n + 1 && j + 1 < m + 1 && map[i + 1][j] != -1 && map[i][j + 1]!= -1) flag = true; 
                if(i + 1 < n + 1 && map[i + 1][j] != -1) {
                    map[i + 1][j] = Math.max(map[i + 1][j], map[i][j] + (flag?1:0));
                }
                if(j + 1 < m + 1 && map[i][j + 1] != -1) {
                    map[i][j + 1] = Math.max(map[i][j + 1], map[i][j] + (flag?1:0));
                }
            }
        }
        return map[n][m];
    }
}