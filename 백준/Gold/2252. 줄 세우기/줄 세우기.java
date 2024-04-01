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
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(in[i] == 0) queue.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(tmp+" ");
            for(int i = 0; i < graph[tmp].size(); i++) {
                in[graph[tmp].get(i)]--;
                if(in[graph[tmp].get(i)] == 0) {
                    queue.add(graph[tmp].get(i));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
