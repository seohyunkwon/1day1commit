import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Room[][] map;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Room[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                char[] dir = String.format("%4s", Integer.toBinaryString(num)).replaceAll(" ", "0").toCharArray();
                Room tmp = new Room();
                // 남, 동, 북 , 서
                tmp.down = dir[0] == '0' ? true : false;
                tmp.right = dir[1] == '0' ? true : false;
                tmp.up = dir[2] == '0' ? true : false;
                tmp.left = dir[3] == '0' ? true : false;
                tmp.x = i; tmp.y = j;
                map[i][j] = tmp;
            }
        }

        visit = new boolean[M][N];
        int room_cnt = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                bfs(map[i][j]);
                room_cnt++;
            }
        }

        System.out.println(room_cnt);
        System.out.println(max);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                findMaxRoom(map[i][j]);
            }
        }
        System.out.println(max);
    }

    static void findMaxRoom(Room room) {
        if(!room.up) {
            visit = new boolean[M][N];
            room.up = true;
            bfs(room);
            room.up = false;
        }
        if(!room.down) {
            visit = new boolean[M][N];
            room.down = true;
            bfs(room);
            room.down = false;
        }
        if(!room.left) {
            visit = new boolean[M][N];
            room.left = true;
            bfs(room);
            room.left = false;
        }
        if(!room.right) {
            visit = new boolean[M][N];
            room.right = true;
            bfs(room);
            room.right = false;
        }
    }

    static void bfs(Room room) {
        Queue<Room> queue = new LinkedList<>();
        queue.offer(room);
        int cnt = 0;

        while(!queue.isEmpty()) {
            Room r = queue.poll();
            if(visit[r.x][r.y]) continue;
            visit[r.x][r.y] = true;
            cnt++;
            if(r.down && r.x + 1 < M && !visit[r.x + 1][r.y]) {
                queue.offer(map[r.x + 1][r.y]);
            }
            if(r.up && r.x - 1 >= 0 && !visit[r.x - 1][r.y]) {
                queue.offer(map[r.x - 1][r.y]);
            }
            if(r.left && r.y - 1 >= 0 && !visit[r.x][r.y - 1]) {
                queue.offer(map[r.x][r.y - 1]);
            }
            if(r.right && r.y + 1 < N && !visit[r.x][r.y + 1]) {
                queue.offer(map[r.x][r.y + 1]);
            }
        }
        max = Math.max(max, cnt);
    }

    static class Room {
        int x, y;
        boolean up, down, left, right;
    }
}
