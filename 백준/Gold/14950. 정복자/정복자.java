import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, t, c;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        c = 0;

        PriorityQueue<Road> roads = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            roads.offer(new Road(A, B, cost));
        }

        p = makeSet(N);

        long result = 0;
        while(c < N-1) {
            Road road = roads.poll();
            int x = road.A;
            int y = road.B;
            int px = find(x);
            int py = find(y);
            if(px != py) {
                union(px, py);
                result += road.cost + (long)(c * t);
                c++;
            }
        }

        System.out.println(result);

    }

    private static void union(int px, int py) {
        p[px] = py;
    }

    private static int find(int x) {
        if(x != p[x]) return p[x] = find(p[x]);
        return p[x];
    }

    private static int[] makeSet(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static class Road implements Comparable<Road> {
        int A, B, cost;

        public Road(int A, int B, int cost) {
            this.A = A;
            this.B = B;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost-o.cost;
        }
    }
}
