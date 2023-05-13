import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,-1

            ,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            String s  = br.readLine();
            for(int j=1; j<=m; j++){
                graph[i][j] = s.charAt(j-1)-'0';
            }
        }

        System.out.println(bfs(1,1));
    }

    public static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]= true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            x= node.x; y=node.y;
            for (int i=0; i<dx.length; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];

                if(nx<1 || ny<1 || nx>n || ny>m) continue;
                if(!visited[nx][ny] && graph[nx][ny]==1){
                    visited[nx][ny]=true;
                    graph[nx][ny] = graph[x][y]+1;
                    queue.add(new Node(nx,ny));
                }
            }
        }

        return graph[n][m];
    }

    public static class Node{
        int x, y;
        public Node(int x, int y){
            this.x=x; this.y=y;
        }
    }
}