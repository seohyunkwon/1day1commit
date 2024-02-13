import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int N, M;
    private static long[][] city;
    private static List<Point> chickens = new ArrayList<>();
    private static List<Point> houses = new ArrayList<>();
    private static boolean[] visit;
    private static long min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new long[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 2) chickens.add(new Point(i, j));
                if(city[i][j] == 1) houses.add(new Point(i, j));
            }
        }

        visit = new boolean[chickens.size()];

        backtracking(0, 0);

        System.out.println(min);

    }

    private static void backtracking(int idx, int depth){
        if(depth == M) {
            getDist();
            return;
        }
        for(int i = idx; i < chickens.size(); i++) {
            visit[i] = true;
            backtracking(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    private static void getDist() {
        long dist = 0;
        for(int i = 0; i < houses.size(); i++) {
            int tmp = Integer.MAX_VALUE;
            for(int j = 0; j < chickens.size(); j++) {
                if(!visit[j]) continue;
                tmp = Math.min(Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y), tmp);
            }
            dist += tmp;
        }
        min = Math.min(min, dist);
    }

    private static class Point {
        int x,  y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
