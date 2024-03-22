import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static int N, result = Integer.MAX_VALUE;
	static Food[] foods;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		foods = new Food[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			foods[i] = new Food(S, B);
		}
		
		getResult(0, 0, 0, 0);
		
		System.out.println(result);
		
	}
	
	static void getResult(int idx, int s_multi, int b_sum, int cnt) {
		if(idx == N) {
			if(cnt == 0) return;
			result = Math.min(result, Math.abs(s_multi - b_sum));
			return;
		}
		// 사용 O
		getResult(idx + 1, s_multi == 0 ? foods[idx].S : s_multi * foods[idx].S, b_sum + foods[idx].B, cnt + 1);
		// 사용 X
		getResult(idx + 1, s_multi, b_sum, cnt);
	}
	
	static class Food {
		int S, B;

		public Food(int s, int b) {
			S = s;
			B = b;
		}
	}
}