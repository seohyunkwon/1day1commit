import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[computers.length][computers[0].length];
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j]==0 || visited[i][j]) continue;
                answer++;
                bfs(visited, i, j, computers);
            }
        }
        return answer;
    }
    
    private void bfs(boolean[][] visited, int x, int y, int[][] computers){
        if(visited[x][y]) return;
        visited[x][y] = true;
        for(int i=0; i<computers[y].length; i++){
            if(computers[y][i]==1)
            bfs(visited, y, i, computers);
        }
    }
}