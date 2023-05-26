import java.util.*;                                  
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    public int bfs(int[][] map){
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0]; int y = arr[1];
            for(int i=0; i<dx.length; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length) continue;
                if(!visited[nx][ny] && map[nx][ny]!=0){
                    map[nx][ny] += map[x][y];
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return map[map.length-1][map[0].length-1]==1?-1:map[map.length-1][map[0].length-1];
    }
}