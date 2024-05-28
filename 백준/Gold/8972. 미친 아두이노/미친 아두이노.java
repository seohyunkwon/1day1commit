import java.io.*;
import java.util.*;

public class Main {
    static Point player;
    static List<Point> enemies;
    static int[][] map;

    static int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        player = new Point(0, 0);
        enemies = new ArrayList<>();
        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String[] arr = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                String tmp = arr[j];
                if(tmp.equals("I")) {
                    player = new Point(i, j);
                } else if(tmp.equals("R")) {
                    enemies.add(new Point(i, j));
                    map[i][j] = -1;
                }
            }
        }

        int[] moves = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .map((num) -> num - 1)
                .toArray();

        int i = 0;

        loop:
        for(i = 0; i < moves.length; i++) {
            // 1단계. 종수가 아두이노를 이동
            player.r += dir[moves[i]][0];
            player.c += dir[moves[i]][1];

            // 2단계. 미친 아두이노가 있는 칸인지 체크
            for(Point enemy : enemies) {
                if(enemy.r == player.r && enemy.c == player.c) break loop;
            }

            // 3단계. 미친 아두이노 이동
            for(int j = 0; j < enemies.size(); j++) {
                Point enemy = enemies.get(j);
                int dist = Integer.MAX_VALUE;
                int idx = -1;
                for(int k = 0; k < 9; k++) {
                    if(k == 4) continue;
                    int nr = enemy.r + dir[k][0];
                    int nc = enemy.c + dir[k][1];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue ;
                    if(dist > Math.abs(nr - player.r) + Math.abs(nc - player.c)) {
                        dist = Math.abs(nr - player.r) + Math.abs(nc - player.c);
                        idx = k;
                    }
                }

                // 4단계
                int nr = enemy.r + dir[idx][0];
                int nc = enemy.c + dir[idx][1];

                if(nr == player.r && nc == player.c) break loop;

                map[enemy.r][enemy.c] = 0;
                map[nr][nc] = -1;

                enemy.r = nr;
                enemy.c = nc;
            }

            // 5단계
            List<Integer> remove = new ArrayList<>();
            Collections.sort(enemies);

            for(int j = 1; j < enemies.size(); j++) {
                Point prev = enemies.get(j - 1);
                Point cur = enemies.get(j);
                if(prev.r == cur.r && prev.c == cur.c) {
                    if(!remove.contains(j - 1)) remove.add(j - 1);
                    if(!remove.contains(j)) remove.add(j);
                }
            }

            if(remove.size() > 0) {
                Collections.sort(remove, Collections.reverseOrder());
                for(int idx : remove) {
                    map[enemies.get(idx).r][enemies.get(idx).c] = 0;
                    enemies.remove(idx);
                }
            }

        }

        if(i != moves.length) {
            System.out.println("kraj " + (i + 1));
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder();

        int[][] result = new int[R][C];
        result[player.r][player.c] = 1;
        for(Point enemy : enemies) {
            result[enemy.r][enemy.c] = -1;
        }

        for(int j = 0; j < R; j++) {
            for(int k = 0; k < C; k++) {
                if(result[j][k] == 1) sb.append("I");
                else if(result[j][k] == -1) sb.append("R");
                else sb.append(".");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }



    static class Point implements Comparable<Point>{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Point o) {
            if(this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
