import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.length()<m) continue;
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			} else map.put(s, 1);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		list.sort((m1, m2)->m1.getValue()!=m2.getValue()?m2.getValue()-m1.getValue():m1.getKey().length()!=m2.getKey().length()?m2.getKey().length()-m1.getKey().length():m1.getKey().compareTo(m2.getKey()));
		Iterator<Map.Entry<String, Integer>> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next().getKey()).append('\n');
		}
		System.out.println(sb);
	}
}
