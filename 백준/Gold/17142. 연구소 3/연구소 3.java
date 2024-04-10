import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, copy;
    static int N, M, result;
    static List<Point> virus;
    static boolean[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copy = new int[N][N];
        virus = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)  {
                    virus.add(new Point(i, j));
                    map[i][j] = Integer.MAX_VALUE;
                }
                if(map[i][j] == 1) map[i][j] = -1;
                if(map[i][j] == 0) map[i][j] = Integer.MAX_VALUE;
                copy[i][j] = map[i][j];
             }
        }

        select = new boolean[virus.size()];
        result = Integer.MAX_VALUE;
        combi(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? - 1 : result);

    }

    static void combi(int idx, int count) {
     
        if(count == M) {
            bfs();
            copyMap();
            return;
        }
        if(idx >= select.length) return;
        select[idx] = true;
        combi(idx + 1, count + 1);
        select[idx] = false;
        combi(idx + 1, count);
    }

    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.depth - o2.depth);
        boolean[][] visit = new boolean[N][N];

        for(int i = 0; i < select.length; i++) {
            Point p = virus.get(i);
            if(select[i]) {
                queue.offer(new Point(p.x, p.y, 0));
            }
        }

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(visit[p.x][p.y]) continue;
            visit[p.x][p.y] = true;
            map[p.x][p.y] = Math.min(p.depth, map[p.x][p.y]);
            for(int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
                if(map[nx][ny] == -1) continue;
                if(map[nx][ny] < p.depth + 1) continue;
                queue.offer(new Point(nx, ny, p.depth + 1));
            }
        }

        for(int i = 0; i < virus.size(); i++) {
            map[virus.get(i).x][virus.get(i).y] = 0;
             visit[virus.get(i).x][virus.get(i).y] = true;
        }
    
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && map[i][j] != -1) return;
            }
        }

        int val = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) val = Math.max(map[i][j], val);
            }
        }
        result = Math.min(result, val);
    }

    static void copyMap(){
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }

    static class Point {
        int x, y, depth;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
