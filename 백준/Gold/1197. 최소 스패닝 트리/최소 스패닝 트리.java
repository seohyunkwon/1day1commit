import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] p = new int[V];
        for(int i = 0; i < V; i++) {
            p[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(A, B, C));
        }
        int sum = 0;
        int count = 0;
        while(count < V - 1) {
            Edge edge = pq.poll();
            int pa = find(p, edge.A);
            int pb = find(p, edge.B);
            if(pa == pb) continue;
            union(p, pa, pb);
            sum += edge.C;
            count++;
        }

        System.out.println(sum);

    }

    static int find(int[] p, int x) {
        if(p[x] != x) return p[x] = find(p, p[x]);
        return p[x];
    }

    static void union(int[] p, int pa, int pb) {
        p[pb] = pa;
    }

    static class Edge implements Comparable<Edge> {
        int A, B, C;

        public Edge(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.C - o.C;
        }
    }
}
