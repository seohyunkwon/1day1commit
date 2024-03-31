import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M, time = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit, isAir;
    static List<Point> cheese = new ArrayList<>();

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
                if(map[i][j] == 1) cheese.add(new Point(i, j));
            }
        }

        while(true) {
            checkAir();
            if(meltingCheese()) {
                time++;
            } else break;
        }

        System.out.println(time);
        
    }

    static boolean meltingCheese(){
        List<Integer> deleteIdx = new ArrayList<>();
        for(int i = 0; i < cheese.size(); i++) {
            Point c = cheese.get(i);
            int count = 0;
            for(int j = 0; j < dx.length; j++) {
                int nx = c.x + dx[j];
                int ny = c.y + dy[j];
                if (inMap(nx, ny) && isAir[nx][ny]) count++;
            }
            if(count >= 2) deleteIdx.add(i);
        }
        if(deleteIdx.size() == 0) return false;
        Collections.sort(deleteIdx, Collections.reverseOrder());
        for(int i : deleteIdx) {
            Point tmp = cheese.get(i);
            map[tmp.x][tmp.y] = 0;
            cheese.remove(i);
        }
        return true;
    }

    static void checkAir() {
        isAir = new boolean[N][M];
        visit = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (visit[p.x][p.y]) continue;
            visit[p.x][p.y] = true;
            isAir[p.x][p.y] = true;
            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (!inMap(nx, ny) || visit[nx][ny] || map[nx][ny] != 0) continue;
                queue.add(new Point(nx, ny));
            }
        }
    }
    
    static boolean inMap(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
