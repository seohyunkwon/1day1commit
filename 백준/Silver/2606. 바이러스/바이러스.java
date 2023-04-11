import java.io.*;
import java.util.*;

class Main{
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// 컴퓨터의 갯수와 링크 갯수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		// 컴퓨터의 갯수(인덱스 1부터 취급)만큼 list 생성
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		// 링크 갯수만큼 입력받고 arraylist에 담아주기
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		// dfs 실행하기 위한 boolean 배열
		visited = new boolean[n+1];
		dfs(1);
		int cnt = -1;
		for(boolean b:visited) {
			if(b) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int x) {
		visited[x]=true;
		for(int i=0; i<list.get(x).size(); i++) {
			int y = list.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
}