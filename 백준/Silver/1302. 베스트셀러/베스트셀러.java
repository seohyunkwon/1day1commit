import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				int value = map.get(s)+1;
				map.put(s, value);
			} else {
				map.put(s, 1);
			}
		}

		Collection<Integer> a = map.values();
		int MAX = Collections.max(a);
		
		Set<String> set = map.keySet();
		List setList = new ArrayList(set);
		Collections.sort(setList);
		Iterator<String> it = setList.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			if(map.get(key)==MAX) {
				System.out.println(key);
				break;
			}
		}
	}
}