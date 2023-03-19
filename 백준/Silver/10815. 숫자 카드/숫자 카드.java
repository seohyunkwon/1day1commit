import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Long> set = new HashSet<Long>();
		while(st.hasMoreTokens()) {
			set.add(Long.parseLong(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			sb.append(set.contains(Long.parseLong(st.nextToken()))?1:0).append(' ');
		}
		System.out.println(sb);
	}
}