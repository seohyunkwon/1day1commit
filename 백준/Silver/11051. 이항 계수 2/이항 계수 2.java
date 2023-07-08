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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            graph[i][0] = 1;
            graph[i][i] = 1;
            graph[i][1] = i;
        }

        for(int i=2; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                graph[i][j] = (graph[i-1][j]+ graph[i-1][j-1])%10007;
            }
        }

        System.out.println(graph[n][k]);


    }
}