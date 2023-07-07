import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {0,0,0,0,1,-1};
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int m,n,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] graph = new int[h][n][m];
        for(int i = 0; i<h; i++){
            for(int j=0; j<n; j++){
                int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=0; k<m; k++){
                    graph[i][j][k] = tmp[k];
                }
            }
        }

        boolean flag = true;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[h][n][m];
        for(int i = 0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==1){
                        queue.add(new int[]{i,j,k});

                    }
                }
            }
        }

        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            visited[tmp[0]][tmp[1]][tmp[2]] = true;
            int cnt = graph[tmp[0]][tmp[1]][tmp[2]];
            for(int i=0; i<dx.length; i++){
                int nz = tmp[0]+dz[i];
                int nx = tmp[1]+dx[i];
                int ny = tmp[2]+dy[i];
                if(nz<0 || nx<0 || ny<0 || nz>=h || nx>=n || ny>=m) continue;
                if(graph[nz][nx][ny]==0 && !visited[nz][nx][ny]){

                    graph[nz][nx][ny] = cnt+1;
                    flag = false;
                    queue.add(new int[]{nz,nx,ny});
                }
            }
        }
        int max = -1;
        for(int i = 0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    max = graph[i][j][k]>max?graph[i][j][k]:max;
                }
            }
        }
        System.out.println(flag?0:max-1);

    }

    public static void bfs(int[][][] graph, int z, int x, int y){

    }
}
