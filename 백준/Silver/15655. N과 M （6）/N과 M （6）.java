import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] select;
	static boolean[] visit;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		select = new int[M];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		getResult(0, 0);
		
		System.out.println(sb.toString());
		
	}
	
	static void getResult(int idx, int num_idx) {
		if(idx == M) {
			for(int i : select) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num_idx; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			select[idx] = numbers[i];
			getResult(idx + 1, i);
			visit[i] = false;
		}
		
	}
}