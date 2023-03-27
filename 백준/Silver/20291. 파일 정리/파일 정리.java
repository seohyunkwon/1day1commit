import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			String[] arr = s.split("[.]");
			s=arr[1];
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			} else map.put(s, 1);
			
		}
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		for(String s:list) {
			sb.append(s+" ").append(map.get(s)).append('\n');
		}
		System.out.println(sb);
	}
}