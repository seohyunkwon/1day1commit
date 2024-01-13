import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer> graph[];
    static boolean[] visited;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        visited = new boolean[N];
        total = 0;
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결
        for(int i=0; i<N-1; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[tmp[0]-1].add(tmp[1]-1);
            graph[tmp[1]-1].add(tmp[0]-1);
        }

        dfs(0, 0);
        System.out.println(total%2 == 0 ? "No" : "Yes");

    }

    static void dfs(int idx, int depth) {
        visited[idx] = true;
        if(graph[idx].size() == 1 && visited[graph[idx].get(0)] ){
            total += depth;
            return;
        }
        for(int i=0; i<graph[idx].size(); i++) {
            if(visited[graph[idx].get(i)]) continue;
            dfs(graph[idx].get(i), depth+1);
        }
    }
}
