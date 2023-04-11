import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int v = Integer.parseInt(st.nextToken());
    	visited = new boolean[n+1];
    	list = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0; i<=n; i++) {
    		list.add(new ArrayList<Integer>());
    	}
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		list.get(a).add(b);
    		list.get(b).add(a);
    	}
    	for(ArrayList<Integer> i : list) {
    		Collections.sort(i);
    	}
    	dfs(v);
    	System.out.println();
    	visited = new boolean[n+1];
    	bfs(v);
    }
    
    public static void dfs(int v) {
    	visited[v] = true;
    	System.out.print(v+" ");
    	for(int i=0; i<list.get(v).size(); i++) {
    		int y = list.get(v).get(i);
    		if(!visited[y]) dfs(y);
    	}
    }
    public static void bfs(int v) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.offer(v);
    	visited[v] = true;
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		System.out.print(x+" ");
    		for(int i=0; i<list.get(x).size(); i++) {
    			int y = list.get(x).get(i);
    			if(!visited[y]) {
    				visited[y] = true;
    				q.offer(y);
    			}
    		}
    	}
    }
}