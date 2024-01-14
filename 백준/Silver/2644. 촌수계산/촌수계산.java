import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2644번 촌수계산
public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 전체 사람의 수 N
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();  // 촌수를 계산해야 하는 사람 A, B
        graph = new ArrayList<>();
        visited = new boolean[N];

        // 그래프 생성
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());    // 관계의 수 M

        // 그래프 연결
        for (int i = 0; i < M; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(tmp[0] - 1).add(tmp[1] - 1);  // 양방향 그래프 연결
            graph.get(tmp[1] - 1).add(tmp[0] - 1);
        }

        System.out.println(dfs(arr[1]-1, 0, arr[0]-1)); // 사람 A에서 사람 B 까지의 거리 출력
    }

    private static int dfs(int idx, int depth, int target) {
        if(idx == target) return depth; // 방문 노드의 값이 target과 같으면 depth 리턴
        visited[idx] = true;
        for (int i = 0; i < graph.get(idx).size(); i++) {
            if (visited[graph.get(idx).get(i)]) continue;
            int result = dfs(graph.get(idx).get(i), depth + 1, target);
            if (result != -1) return result;   // 친척 관계인 경우(!=-1) 반환된 depth 값 리턴
        }
        return -1;  // 친척 관계가 아닌 경우 -1 리턴
    }
}
