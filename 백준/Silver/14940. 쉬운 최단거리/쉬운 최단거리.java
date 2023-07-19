import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        int[] start = new int[2];
        for(int i=0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
               graph[i][j] = arr[j];
               if(arr[j]==2){
                   start[0] = i;
                   start[1] = j;
               }
            }
        }

        boolean[][] visited = new boolean[n][m];
        bfs(start, graph, visited);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j]==1) graph[i][j] = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int[] start, int[][] graph, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        graph[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(visited[tmp[0]][tmp[1]]) continue;
            visited[tmp[0]][tmp[1]] = true;

            for(int i=0; i<dx.length; i++){
                int nx  = tmp[0] + dx[i];
                int ny  = tmp[1] + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny]==0) continue;
                graph[nx][ny] = graph[tmp[0]][tmp[1]]+1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

}