import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		for(int i:list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}