import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visit;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Point> walls;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        walls = new ArrayList<>();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = arr[j] - '0';
                if(map[i][j] == 1) walls.add(new Point(i, j, 0));
            }
        }

        bfs();

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);



    }

    static void bfs(){
        visit = new boolean[N][M][2];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        visit[0][0][0] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x == N-1 && p.y == M-1) {
                result = Math.min(result, p.depth);
                break;
            }
            for(int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 1) {
                    if(!p.isValid || visit[nx][ny][1]) continue;
                    visit[nx][ny][1] = true;
                    queue.offer(new Point(nx, ny, p.depth+1, false));
                } else {
                    if(p.isValid && !visit[nx][ny][0]) {
                        visit[nx][ny][0] = true;
                        queue.offer(new Point(nx, ny, p.depth + 1, true));
                    }
                    if(!p.isValid && !visit[nx][ny][1]) {
                        visit[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, p.depth + 1, false));
                    }
                }
            }
        }
    }

    static class Point {
        int x, y, depth;
        boolean isValid;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isValid = true;
        }

        public Point(int x, int y, int depth, boolean isValid) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isValid = isValid;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", depth=" + depth +
                    ", isValid=" + isValid +
                    '}';
        }
    }
}
