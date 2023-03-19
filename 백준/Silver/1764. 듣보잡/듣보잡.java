import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		for(int i=0; i<m; i++) {
			String s=br.readLine();
			if(set.contains(s)) {
				list.add(s);
			}
		}
		Collections.sort(list);
		for(String a : list) {
			sb.append(a).append('\n');
		}
		System.out.println(list.size());
		System.out.println(sb);
	}
}