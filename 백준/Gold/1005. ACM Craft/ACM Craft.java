import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N + 1];
            int[] result = new int[N + 1];
            st = new StringTokenizer(br.readLine());

            List<Integer>[] graph = new ArrayList[N + 1];
            int[] in = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                result[i] = time[i];
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                in[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i = 1; i <= N; i++) {
                if(in[i] == 0) queue.offer(i);
            }

            while(!queue.isEmpty()) {
                int now = queue.poll();
                for(int i = 0; i < graph[now].size(); i++) {
                    int next = graph[now].get(i);
                    in[next]--;
                    result[next] = Math.max(result[next], result[now] + time[next]);
                    if(in[next] == 0) queue.offer(next);
                }
            }
            System.out.println(result[W]);
        }
    }
}
