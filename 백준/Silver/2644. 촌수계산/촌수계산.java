import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        graph = new ArrayList<>();
        visited = new boolean[N];
        // 노드 생성
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int M = Integer.parseInt(br.readLine());
        
        // 그래프 연결
        for (int i = 0; i < M; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(tmp[0] - 1).add(tmp[1] - 1);
            graph.get(tmp[1] - 1).add(tmp[0] - 1);
        }

        System.out.println(dfs(arr[1]-1, 0, arr[0]-1));
    }

    private static int dfs(int idx, int depth, int target) {
        if(idx == target) return depth;
        visited[idx] = true;
        for (int i = 0; i < graph.get(idx).size(); i++) {
            if (visited[graph.get(idx).get(i)]) continue;
            int result = dfs(graph.get(idx).get(i), depth + 1, target);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

}
