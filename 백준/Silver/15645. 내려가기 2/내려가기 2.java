import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] max_dp = new int[N][3];
        int[][] min_dp = new int[N][3];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    max_dp[i][j] = map[i][j];
                    min_dp[i][j] = map[i][j];
                }
            }
        }
        for(int i = 1; i < N; i++) {
            max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1]) + map[i][0];
            max_dp[i][1] = Math.max(max_dp[i-1][0], Math.max(max_dp[i-1][1], max_dp[i-1][2])) + map[i][1];
            max_dp[i][2] = Math.max(max_dp[i-1][2], max_dp[i-1][1]) + map[i][2];
            min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1]) + map[i][0];
            min_dp[i][1] = Math.min(min_dp[i-1][0], Math.min(min_dp[i-1][1], min_dp[i-1][2])) + map[i][1];
            min_dp[i][2] = Math.min(min_dp[i-1][2], min_dp[i-1][1]) + map[i][2];
        }

        System.out.print(Math.max(Math.max(max_dp[N-1][0], max_dp[N-1][1]), max_dp[N-1][2])+" ");
        System.out.println(Math.min(Math.min(min_dp[N-1][0], min_dp[N-1][1]), min_dp[N-1][2]));
    }
}
