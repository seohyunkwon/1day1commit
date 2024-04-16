import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean isValid;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++) {
            isValid = false;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Point[] points = new Point[N + 2];
            visit = new boolean[N + 2];
            points[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }
            st = new StringTokenizer(br.readLine());
            points[N + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            graph = new ArrayList[N + 2];
            for(int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i = 0; i < points.length - 1; i++) {
                for(int j = i + 1; j < points.length; j++) {
                    if(getDist(points[i], points[j]) <= 1000) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }

            dfs(0);

            System.out.println(isValid?"happy":"sad");

        }
    }

    static void dfs(int idx) {
        if(idx == graph.length - 1) {
            isValid = true;
            return;
        }
        if(visit[idx]) return;
        visit[idx] = true;
        for(int i = 0; i < graph[idx].size(); i++) {
            dfs(graph[idx].get(i));
        }
    }

    static int getDist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
