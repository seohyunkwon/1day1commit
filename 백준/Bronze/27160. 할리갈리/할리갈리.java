import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+value);
			} else map.put(key, value);
		}
		List<Integer> list = new ArrayList<Integer>(map.values());
		System.out.println(list.contains(5)?"YES":"NO");
	}
}
