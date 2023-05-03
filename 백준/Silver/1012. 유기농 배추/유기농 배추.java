import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static  int[][] graph;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt = 0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int j=0; j<t; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            for(int i=0; i<graph.length; i++){
                for(int l = 0; l<graph[i].length; l++){
                   if(graph[i][l]==1) {
                       dfs(i,l);
                       cnt++;
                   }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }


    public static void dfs(int y, int x){
        if(x<0 || y<0 || x>m-1 || y>n-1 || graph[y][x]==0) return;
        graph[y][x] = 0;
        for(int i=0; i<dx.length; i++){
            dfs(y+dy[i], x+dx[i]);
        }
    }

}
