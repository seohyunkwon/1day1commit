import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] tmp : puddles) {
            map[tmp[1] - 1][tmp[0] - 1] = -1;
        }
                
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    map[i][j] = 1;
                    continue;
                }
                if(map[i][j] == -1) continue;
                if(i - 1 >= 0 && map[i-1][j] != -1) map[i][j] += map[i - 1][j];
                if(j - 1 >= 0 && map[i][j-1] != -1) map[i][j] += map[i][j - 1];
                map[i][j] %= 1_000_000_007;
            }
        }
        return map[n - 1][m - 1];
    }
}