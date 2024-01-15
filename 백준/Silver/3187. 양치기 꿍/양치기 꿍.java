import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3187번 양치기 꿍
public class Main {

    private static int[][] farm;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int wolves;
    private static int sheeps;
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        farm = new int[R][C];
        int[] result = new int[2];  // {양, 늑대}
        for(int i=0; i<R; i++) {
            // 빈공간(.) : 0, 울타리(#) : -1, 늑대(v) : 1, 양(k) : 2
            farm[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(str -> str.equals(".")?0:str.equals("#")?-1:str.equals("v")?1:2)
                    .toArray();
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                wolves = farm[i][j]==1?1:0;
                sheeps = farm[i][j]==2?1:0;
                if(farm[i][j] == -1) continue;
                dfs(i, j);
                if(sheeps>wolves) {
                    result[0] += sheeps;
                } else {
                    result[1] += wolves;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }

    private static void dfs(int x, int y) {
        if(farm[x][y] == -1) return;
        farm[x][y] = -1;
        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny<0 || nx >= R || ny>= C || farm[nx][ny] == -1) continue;
            if(farm[nx][ny] == 1) {
                wolves++;
                farm[nx][ny] = 0;
            }
            if(farm[nx][ny] == 2) {
                sheeps++;
                farm[nx][ny] = 0;
            }
            dfs(nx, ny);

        }
    }
}
