import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<Road>[] graph = new ArrayList[D + 1];
        for(int i = 0;  i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(target > D) continue;
            if(target - start < length) continue;
            graph[start].add(new Road(target, length));
        }
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0; i < D; i++) {
            dist[i + 1] = Math.min(dist[i] + 1, dist[i + 1]);

            for(int j = 0; j < graph[i].size(); j++) {
                Road r = graph[i].get(j);
                if(dist[r.target] > dist[i] + r.length) {
                    dist[r.target] = dist[i] + r.length;
                }
            }
        }

        System.out.println(dist[D]);
    }

    static class Road{
        int target, length;

        public Road(int target, int length) {
            this.target = target;
            this.length = length;
        }
    }
}
