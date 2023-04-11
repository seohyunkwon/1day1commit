import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		boolean[] visited = new boolean[n+1];
		Stack<Integer> st = new Stack<Integer>();
	
		st.push(1);
		visited[1]=true;
		while(!st.isEmpty()) {
			int idx = st.pop();
			for(int i=0; i<list.get(idx).size(); i++) {
				int y = list.get(idx).get(i);
				if(!visited[y]) {
					st.push(y);
					visited[y]=true;
				}
			}
		}
		int cnt = -1;
		for(boolean b:visited) {
			if(b) cnt++;
		}
		System.out.println(cnt);
		
		
		
		
	}
}