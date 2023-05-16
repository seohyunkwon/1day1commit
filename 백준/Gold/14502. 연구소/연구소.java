import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static int[][] graph;
    static int[][] tmp;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Node[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int k=i; k<=n; k++){
                    for(int l=1; l<=m; l++){
                        for(int o=i; o<=n; o++){
                            for(int p=1; p<=m; p++){
                                if((i==k) && (j==l)) continue;
                                if((o==k) && (p==l)) continue;
                                if((i==o) && (j==p)) continue;

                                if(graph[i][j] ==0 && graph[k][l] == 0&& graph[o][p]==0){
                                    list.add(new Node[]{new Node(i,j), new Node(k,l), new Node(o,p)});
                                }
                            }
                        }
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            int cnt = 0;
            Node[] arr= list.get(i);
            tmp = new int[n+1][m+1];
            for(int j=1; j<=n; j++){
                for(int k=1; k<=m; k++){
                    tmp[j][k] = graph[j][k];
                }
            }
            for(Node node : arr){
                tmp[node.x][node.y] = 1;
            }
            for(int j=1; j<=n; j++){
                for(int k=1; k<=m; k++){
                    if(tmp[j][k]==2) {
                        bfs(j,k);
                    }
                }
            }

            for(int j=1; j<=n; j++){
                for(int k=1; k<=m; k++){
                    if(tmp[j][k]==0) cnt++;
                }
            }
            result = Math.max(cnt, result);
        }
        System.out.println(result);

    }

    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx<1 || ny<1 || nx>n || ny>m || tmp[nx][ny]!=0) continue;
                tmp[nx][ny]=2;
                queue.offer(new Node(nx, ny));
            }
        }
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x=x; this.y=y;
        }
    }
}