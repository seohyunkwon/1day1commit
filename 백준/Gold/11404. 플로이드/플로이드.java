import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, INF = 10_000_000;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                cost[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], c);
        }

        floyd();

        StringBuilder sb = new StringBuilder();

        for(int[] arr : cost) {
            for(int i : arr) {
                if(i == INF) i = 0;
                sb.append(i + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void floyd() {
        for(int k = 0; k < n; k++) {
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < n; i++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
    }
}
