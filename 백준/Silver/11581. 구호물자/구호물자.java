import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static String result = "NO CYCLE";
    private static boolean isCycle;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        StringTokenizer st;
        isCycle = false;
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }
        visited = new boolean[N];
        dfs(0);
        if(isCycle) result = "CYCLE";
        System.out.println(result);
    }
    private static void dfs(int idx) {
        visited[idx] = true;
        for(int i : graph[idx]) {
            if(visited[i]) {
                isCycle = true;
                return;
            }
            dfs(i);
        }
        visited[idx] = false;
    }
}