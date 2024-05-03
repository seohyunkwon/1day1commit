import java.io.*;
import java.util.*;

public class Main {
	static int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N + 1][N + 1];
        
        for(int i = 1; i < N + 1; i++) {
        	Arrays.fill(graph[i], INF);
        }
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	graph[a][b] = Math.min(c, graph[a][b]);
        	graph[b][a] = Math.min(c, graph[b][a]);
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < N + 1; i++) {
			graph[i][i] = 0;
        }
        
        for(int k = 1; k < N + 1; k++) {
        	for(int i = 1; i < N + 1; i++) {
        		for(int j = 1; j < N + 1; j++) {
        			graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        		}
        	}
        }
        // 1 - a - b - N
        // 1 - b - a - N
        
        int tmp = Math.min(graph[1][v2]+graph[v2][v1]+graph[v1][N], graph[1][v1]+graph[v1][v2]+graph[v2][N]);
        System.out.println(tmp >= INF ? -1 : tmp);
        
    }
    
    static class Node {
    	int idx, dist;
    	boolean isVisitV1, isVisitV2;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
    }
}
