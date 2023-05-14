import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = 1;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(graph[i][j]==1) {
                    queue.add(new Node(i,j));
                    visited[i][j]= true;
                }
            }
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > m || graph[nx][ny] == -1) continue;
                if(!visited[nx][ny]){
                    graph[nx][ny] = graph[node.x][node.y] + 1;
                    max = Math.max(max, graph[nx][ny]);
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] =true;
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(graph[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
            }
        }


        System.out.println(max-1);
    }

    static class Node {
        int x, y;
        Node(int x, int y){
            this.x=x; this.y=y;
        }
    }
}