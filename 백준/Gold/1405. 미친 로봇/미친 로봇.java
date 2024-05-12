import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, E, W, S, N;
    static double sum = 0;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동 서 남 북
    static int[] weight;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        weight = new int[] {E, W, S, N};
        select = new int[C];
        visit = new boolean[2 * C + 1][2 * C + 1];
        visit[C][C] = true;
        move(C, C, 0);
        System.out.println(1 - sum);
    }

    static void move(int r, int c, int depth) {
        if (depth == C) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(weight[i] == 0) continue;
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(visit[nr][nc]) {
                select[depth] = i;
                getSum(depth);
                continue;
            }
            visit[nr][nc] = true;
            select[depth] = i;
            move(nr, nc, depth + 1);
            visit[nr][nc] = false;
        }
    }

    static void getSum(int depth) {
        double tmp = 1;
        for (int i = 0; i <= depth; i++) {
            int idx = select[i];
            tmp *= weight[idx] / 100.0;
        }
        sum += tmp;
    }
}
