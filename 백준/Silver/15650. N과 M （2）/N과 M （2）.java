import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] selected;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        selected = new int[M];
        sb = new StringBuilder();

        backtracking(0);

        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if(depth == M) {
            for(int i:selected) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++) {
            if(visited[i] || (depth>0 && selected[depth-1]>i)) continue;
            selected[depth] = i;
            visited[i] = true;
            backtracking(depth+1);
            visited[i] = false;
        }
    }
}