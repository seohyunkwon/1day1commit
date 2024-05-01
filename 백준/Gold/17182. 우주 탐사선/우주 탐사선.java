import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, result = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getMinDist();

        getDist(K, 0);

        System.out.println(result);

    }

    static void getDist(int idx, int sum) {
        boolean flag = true;

        for(int i = 0; i < N; i++) {
            if(i == idx) continue;
            if(!visit[i]) {
                flag = false;
                break;
            }
        }

        if(flag) {
            result = Math.min(result, sum);
            return;
        }


        for(int i = 0; i < N; i++) {
            if(i == idx || visit[i]) continue;
            visit[idx] = true;
            getDist(i, sum + cost[idx][i]);
            visit[idx] = false;
        }

    }

    static void getMinDist() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    cost[i][k] = Math.min(cost[i][k], cost[i][j] + cost[j][k]);
                }
            }
        }
    }
}
