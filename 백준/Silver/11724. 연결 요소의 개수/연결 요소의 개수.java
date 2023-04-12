import java.io.*;
import java.time.Year;
import java.util.*;

public class Main {
    static int n, m;
    static int cnt = 0;
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
        	list.get(a).sort((k,j)->k-j);
        	list.get(b).sort((k,j)->k-j);
        }
        visited = new boolean[n+1];
        int k = searchVisited();
        while(k<=n) {
        	dfs(k);
        	k = searchVisited();
        }
        System.out.println(cnt);
    }

    public static void dfs(int x) {
    	if(x<1 || x>n) return;
    	visited[x]=true;
    	for(int i=0; i<list.get(x).size(); i++) {
    		int y = list.get(x).get(i);
    		if(!visited[y]) dfs(y);
    	}
    }
    
    public static int searchVisited() {
    	int i=0;
    	for(i=1; i<visited.length; i++) {
    		if(!visited[i]) break;
    	}
    	if(i>0 && i<=n) cnt++;
    	return i;
    }
}
