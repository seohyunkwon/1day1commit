import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 사람의 수
        int M = Integer.parseInt(st.nextToken());    // 친구 관계의 수
        graph = new ArrayList[N];

        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            if(dfs(i, 0) >= 4) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static int dfs(int idx, int depth) {
        if(depth >= 4) return depth;
        visited[idx] = true;
        int max = 0;
        for(int i=0; i< graph[idx].size(); i++) {
            if(visited[graph[idx].get(i)]) continue;
            max = Math.max(dfs(graph[idx].get(i), depth+1), max);
        }
        visited[idx] = false;
        return max;
    }
}