import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] idx = {0,0};
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(visited[tmp[0]][tmp[1]]) continue;
            visited[tmp[0]][tmp[1]] = true;
            for(int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length)
                    continue;
                if(maps[nx][ny]==0||visited[nx][ny]) continue;
                maps[nx][ny] = maps[tmp[0]][tmp[1]]+1;
                queue.add(new int[]{nx, ny});
            }
        }
        
        return maps[maps.length-1][maps[0].length-1]==1?-1:maps[maps.length-1][maps[0].length-1];
    }
}