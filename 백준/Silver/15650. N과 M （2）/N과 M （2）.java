import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] select;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		select = new int[M];
		visit = new boolean[N + 1];
		
		getResult(1, 0);
		
		System.out.println(sb.toString());
		
	}
	
	static void getResult(int num, int idx) {
		if(idx == M) {
			for(int i : select) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num; i <= N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			select[idx] = i;
			getResult(i, idx + 1);
			visit[i] = false;
		}
	}
}