import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer>map=new HashMap<Integer, Integer>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else map.put(key, 1);
		}
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			sb.append(map.containsKey(k)?map.get(k):0).append(' ');
		}
		System.out.println(sb);
	}
}