import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] in = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            in[B]++;
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(in[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            result.add(tmp);
            for(int i = 0; i < graph[tmp].size(); i++) {
                in[graph[tmp].get(i)]--;
                if(in[graph[tmp].get(i)] == 0) {
                    queue.add(graph[tmp].get(i));
                }
            }
        }
        for(int i : result) System.out.print(i + " ");
    }
}
