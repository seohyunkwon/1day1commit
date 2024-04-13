import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == 0 && j == 0) dp[i][j] = maze[i][j];
                else if(i == 0) {
                    dp[i][j] = dp[i][j-1] + maze[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + maze[i][j];
                } else continue;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == 0 || j == 0) continue;
                int max = dp[i-1][j-1];
                if(dp[i-1][j] > max) max = dp[i-1][j];
                if(dp[i][j-1] > max) max = dp[i][j-1];
                dp[i][j] = max + maze[i][j];
            }
        }

        System.out.println(dp[N-1][M-1]);

    }
}
