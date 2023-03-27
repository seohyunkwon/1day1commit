import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			if(map.containsKey(k)) {
				map.put(k, -1);
			}
		}
		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		Collections.sort(list);
		for(int i : list) {
			if(map.get(i)==1) {
				sb.append(i).append(" "); cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}