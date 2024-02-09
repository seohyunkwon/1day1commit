import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int[][] board;
    private static int N;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            board[0][i] = 1;
            backtracking(1);
            board[0][i] = 0;
        }
        System.out.println(count);
    }

    private static void backtracking(int x) {
        if(x == N) {
            count++;
            return;
        }
        for(int i=0; i<N; i++) {
            if(check(x, i)) {
            board[x][i] = 1;
            backtracking(x+1);
            board[x][i] = 0;
            }
        }
    }

    private static boolean check(int x, int y) {

        for(int i = 0; i < x; i++) {
            if(board[i][y] == 1) return false;
        }
        for(int i = 1; i < N; i++) {
            if(!inMap(x-i, y+i)) break;
            if(board[x-i][y+i] == 1) return false;
        }
        for(int i = 1; i < N; i++) {
            if(!inMap(x-i, y-i)) break;
            if(board[x-i][y-i] == 1) return false;
        }

        return true;
    }

    private static boolean inMap(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < N;
    }
}