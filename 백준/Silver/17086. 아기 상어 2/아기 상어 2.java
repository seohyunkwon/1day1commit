import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bfs(new Point(i, j, 0));
            }
        }

        System.out.println(result);

    }

    static void bfs(Point start) {
        boolean[][] visit = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(map[p.r][p.c] == 1) {
                result = Math.max(result, p.dist);
                return;
            }
            if(visit[p.r][p.c]) continue;
            visit[p.r][p.c] = true;
            for(int i = 0; i < dr.length; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) continue;

                q.offer(new Point(nr, nc, p.dist + 1));
            }
        }
    }

    static class Point {
        int r, c, dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
