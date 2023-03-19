import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if(map.containsKey(a) && b.equals("leave")) map.put(a, true);
			else map.put(a, false);
		}

		ArrayList<String> list = new ArrayList<String>(map.keySet());
		
		Collections.sort(list, Collections.reverseOrder());
		for(String s:list) {
			if(!map.get(s)) {
				sb.append(s).append('\n');
			}
		}
		System.out.println(sb);
	
	
	}
}