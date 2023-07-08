import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {0,0,0,0,1,-1};
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int j=0; j<t; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] graph = new int[m+1][n+1];
            for(int i=0; i<m+1; i++){
                graph[i][0] = 1;
                graph[i][1] = i;
                if(i<=n) graph[i][i] = 1;
            }

            for(int i=0; i<n+1; i++){
                graph[1][i] = 1;
            }

            for(int i=2; i<m+1; i++){
                for(int k=1; k<n+1; k++){
                    if(i==k) continue;
                    graph[i][k] = graph[i-1][k]+graph[i-1][k-1];
                }
            }

            System.out.println(graph[m][n]);
        }


    }
}