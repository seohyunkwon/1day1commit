import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			map.put(br.readLine(), 0);
		}
		int cnt=0;
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) cnt++;
		}
		
		System.out.println(cnt);
	}
}