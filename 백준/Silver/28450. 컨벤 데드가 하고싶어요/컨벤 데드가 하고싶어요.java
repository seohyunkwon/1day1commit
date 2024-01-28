import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int H = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(i == j && i == 1) continue;
                int up = i-1;
                int left = j-1;
                if(up == 0) {
                    dp[i][j] += dp[i][left];
                } else if(left == 0) {
                    dp[i][j] += dp[up][j];
                } else {
                    dp[i][j] += Math.min(dp[up][j], dp[i][left]);
                }
            }
        }

        if(dp[N][M] <= H) {
            System.out.println("YES");
            System.out.println(dp[N][M]);
            return;
        }
        System.out.println("NO");
    }
}