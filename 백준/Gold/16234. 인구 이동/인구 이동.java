import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R, count = 0;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<World> select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        select = new ArrayList<>();
        loop:
        while (true) {
            boolean flag = true;
            visit = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    bfs(new World(i, j));
                    if(select.size() > 1) {
                        int sum = 0;
                        for (int k = 0; k < select.size(); k++) {
                            World tmp = select.get(k);
                            sum += map[tmp.x][tmp.y];
                        }

                        sum /= select.size();

                        for (World w : select) {
                            map[w.x][w.y] = sum;
                        }

                        flag = false;
                    }
                }
            }

            if(flag) break;
            count++;
        }


        System.out.println(count);


    }

    static void bfs(World start) {
        Queue<World> queue = new LinkedList<>();
        queue.offer(start);
        select.clear();

        while(!queue.isEmpty()) {
            World w = queue.poll();
            if(visit[w.x][w.y]) continue;
            visit[w.x][w.y]  = true;
            select.add(w);
            for(int i = 0; i < dx.length; i++) {
                int nx = w.x + dx[i];
                int ny = w.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
                int tmp = Math.abs(map[w.x][w.y] - map[nx][ny]);
                if(tmp < L || tmp > R) continue;
                queue.offer(new World(nx, ny));
            }
        }
    }

    static class World {
        int x, y;

        public World(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
