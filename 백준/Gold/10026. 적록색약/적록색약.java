import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n;
    static char[][] graph1;
    static char[][] graph2;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph1 = new char[n+1][n+1];
        graph2 = new char[n+1][n+1];

        for (int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=n; j++){
                graph1[i][j] = s.charAt(j-1);
                graph2[i][j] = s.charAt(j-1)=='G'?'R':s.charAt(j-1);
            }
        }
        int cnt = 0;
        visited = new boolean[n+1][n+1];
        for (int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph1[i][j]!='0'){
                    dfs(i,j,graph1);
                    cnt++;
                }
            }
        }

        System.out.print(cnt+" ");

        cnt = 0;
        visited = new boolean[n+1][n+1];
        for (int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph2[i][j]!='0'){
                    dfs(i,j,graph2);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, char[][] graph){
        visited[x][y] = true;
        int tmp = graph[x][y];
        graph[x][y] = '0';
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(ny<1 || nx<1 | nx>n || ny >n) continue;
            if(graph[nx][ny] != '0' && graph[nx][ny]==tmp) {
                dfs(nx, ny, graph);
            }
        }
    }
}