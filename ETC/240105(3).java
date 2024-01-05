import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public static List<List<Integer>> graph;
	public static boolean[] visited;
	public static void main(String args[]) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 sc.nextLine();
		 for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			visited = new boolean[N];
			graph = new ArrayList<>();
			for(int i=0; i<N; i++) {
				graph.add(new ArrayList<>());
			}
			for(int j=0; j<M; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				sc.nextLine();
				graph.get(a-1).add(b-1);
				graph.get(b-1).add(a-1);
			}
			int count = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) continue;
				count++;
				dfs(i);
			}
			System.out.printf("#%d %d\n", test_case, count);
		 }
	}
	
	public static void dfs(int idx) {
		if(visited[idx]) return;
		visited[idx] = true;
		List<Integer> list = graph.get(idx);
		for(int i=0; i<list.size(); i++) {
			if(visited[list.get(i)]) continue;
			dfs(list.get(i));
		}
	}
}
