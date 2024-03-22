import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int[] arr, select = new int[6];
	static boolean[] visit;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st;
		while (!(str = br.readLine()).equals("0")) {
			st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			visit = new boolean[k];
			sb = new StringBuilder();

			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			getLottos(0, 0);
			System.out.println(sb.toString());

		}
	}

	static void getLottos(int num_idx, int select_idx) {
		if (select_idx == 6) {
			for (int i : select) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = num_idx; i < k; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			select[select_idx] = arr[i];
			getLottos(i + 1, select_idx + 1);
			visit[i] = false;
		}
		
	}
}
