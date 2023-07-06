import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];

        for(int i=0; i<n; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
                graph[i][j] = tmp[j];
            }
        }
        int cnt = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == 1){
                    cnt++;
                    int a = bfs(graph, i, j);
                    max = max>a?max:a;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    public static int bfs(int[][] graph, int x, int y){
        int total = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(graph[tmp[0]][tmp[1]]==0) continue;
            graph[tmp[0]][tmp[1]] = 0;
            total++;

            for(int i=0; i< dx.length; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<0 || ny<0 || nx>= graph.length || ny>= graph[0].length || graph[nx][ny]==0) continue;
                queue.add(new int[]{nx,ny});
            }
        }
        return total;
    }
}
