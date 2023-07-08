import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j]==1 && !visited[i][j]) {
                    bfs(i,j, computers, visited);
                    answer++;
                }
            }
        }
        
        for(boolean[] b: visited){
            System.out.println(Arrays.toString(b));
            boolean flag = true;
            for(int i=0; i<b.length; i++){
                if(b[i]) flag = false;
            }
            if(flag) answer++;
        }
        
        return answer;
    }
    
    public void bfs(int x, int y, int[][] computers,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(visited[tmp[0]][tmp[1]]) continue;
            visited[tmp[0]][tmp[1]] = true;
            for(int i=0; i<computers.length; i++){
                if(!visited[tmp[1]][i] && tmp[1]!=i && computers[tmp[1]][i]==1){
                    queue.add(new int[]{tmp[1], i});
                }
            }
            
        }
    }
}