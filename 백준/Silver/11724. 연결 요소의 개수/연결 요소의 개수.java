import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<ArrayList<Integer>>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
        visited = new boolean[n+1];
        int cnt = 0;
        for(int i=1; i<=n; i++) {
        	if(!visited[i]) {
        		dfs(i);
        		cnt++;
        	}
        }
        System.out.println(cnt);
    }

    public static void dfs(int x) {
    	visited[x]=true;
    	for(int i:list.get(x)) {
    		if(!visited[i]) dfs(i);
    	}
    }
}
