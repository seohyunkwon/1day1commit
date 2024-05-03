import java.io.*;
import java.util.*;

public class Main {
	static int N, INF = 200_000_000;
	static int[][] dist, graph;
	static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][N + 1];
        
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
        
        dist = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++) {
        	Arrays.fill(dist[i], INF);        	
        }
        
        dijkstra(1);
        dijkstra(v1);
        dijkstra(v2);
        
        int result = Math.min(dist[1][v1] + dist[v1][v2] + dist[v2][N], dist[1][v2] + dist[v2][v1] + dist[v1][N]);
        
//        for(int[] arr : dist) {
//        	System.out.println(Arrays.toString(arr));
//        }
        
        System.out.println(result >= INF ? -1 : result);
        
        
    }
    
    static void dijkstra(int idx) {
    	pq = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
    	dist[idx][idx] = 0;
    	pq.offer(new Node(idx, 0));
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		for(int i = 1; i < N + 1; i++) {
    			if(i == idx) continue;
    			if (dist[idx][i] > dist[idx][node.idx] + graph[node.idx][i]) {
                    dist[idx][i] = dist[idx][node.idx] + graph[node.idx][i];
                    pq.offer(new Node(i, dist[idx][i]));
                }
    			
    		}
    	}
    	
    }
    
    static class Node {
    	int idx, dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
    }
}
