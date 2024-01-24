import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    private static int result, R, C;

    private static int[] dx;
    private static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for(int i=0; i<R; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int N = Integer.parseInt(br.readLine());

        dx = new int[N];
        dy = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            dx[i] = Integer.parseInt(st.nextToken());
            dy[i] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[R][C];
        int result = bfs(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int bfs(int row){
        Queue<Node> queue = new ArrayDeque<>();
        for(int i=0; i<C; i++) {
            if(board[row][i] == 0) continue;
            queue.add(new Node(row, i, 0));
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == R-1) {
                return node.dist;
            }

            for(int i=0; i<dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length
                        || visited[nx][ny] || board[nx][ny] == 0) continue;

                queue.add(new Node(nx, ny, node.dist + 1));
                visited[nx][ny] = true;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}