import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int N, K, dir_idx, second, hx, hy, tx, ty, X, Y;
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                X  = Integer.parseInt(st.nextToken())-1;
                Y  = Integer.parseInt(st.nextToken())-1;
                board[X][Y] = -1;
        }

        int L = Integer.parseInt(br.readLine());
        dir_idx = 0; second = 1;
        hx = 0; hy = 0;
        tx = 0; ty = 0;
        board[hx][hy] = 1;
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            move();
            changeDirect(C);
        }

        X = Integer.MAX_VALUE;

        move();
    }

    private static boolean isValid(int x, int y){
        return 0 <= x && 0 <= y && x < N && y < N && board[x][y] <= 0;
    }

    private static void changeDirect(String C){
        if(C.equals("L")) {
            dir_idx= (dir_idx - 1 + 4) % 4;
        } else {
            dir_idx = (dir_idx+1)%4;
        }
    }

    private static void move(){
        while(true) {
            int nx = hx + dx[dir_idx];
            int ny = hy + dy[dir_idx];
            if(!isValid(nx, ny)) {
                System.out.println(second);
                System.exit(0);
            }
            int tmp = board[nx][ny];
            board[nx][ny] = second++;
            if(tmp != -1) {
                int min_value = Integer.MAX_VALUE;
                int min_x = -1;
                int min_y = -1;
                for(int k=0; k<dx.length; k++) {
                    int ntx = tx + dx[k];
                    int nty = ty + dy[k];
                    if(ntx < 0 || nty < 0 || ntx >= N || nty >= N || board[ntx][nty] < 1) continue;
                    if(min_value > board[ntx][nty]) {
                        min_x = ntx;
                        min_y = nty;
                        min_value = board[ntx][nty];
                    }
                }
                board[tx][ty] = 0;
                if(min_x != -1 && min_y != -1) {
                    tx = min_x;
                    ty = min_y;
                }
            }
            hx = nx;
            hy = ny;
            if(second>X) break;
        }
    }
}