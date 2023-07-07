import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1,-1,-2,-2,1,1,2,2};
    static int[] dy = {-2,2,-1,1,-2,2,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
                int l = Integer.parseInt(br.readLine());
                int[][] graph = new int[l][l];
                boolean[][] visited = new boolean[l][l];
                int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(start);
                while(!queue.isEmpty()){
                    int[] tmp = queue.poll();
                    if(tmp[0]==end[0] && tmp[1]==end[1]) break;
                    if(visited[tmp[0]][tmp[1]]) continue;
                    visited[tmp[0]][tmp[1]] = true;
                    for(int k=0; k< dx.length; k++){
                        int nx = tmp[0]+dx[k];
                        int ny = tmp[1]+dy[k];
                        if(nx<0 || ny<0 || nx>=l || ny>=l || visited[nx][ny]) continue;
                        graph[nx][ny] = graph[tmp[0]][tmp[1]]+1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            
                sb.append(graph[end[0]][end[1]]+"\n");

        }
            System.out.println(sb);
    }
}