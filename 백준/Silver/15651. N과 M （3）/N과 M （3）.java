import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] result;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        result = new int[M];
        sb = new StringBuilder();
        backtracking(1, 0);
        System.out.print(sb);
    }

    private static void backtracking(int start, int depth) {
        if (depth == M) {
            for(int i : result) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            result[depth] = i;
            backtracking(i+1, depth + 1);
            visited[i] = false;
        }
    }
}