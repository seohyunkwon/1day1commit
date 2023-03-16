import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		HashMap<Long, Long> map = new HashMap<Long,Long>();
		for(long i=0; i<n; i++) {
			long key = Long.parseLong(br.readLine());
			if(map.containsKey(key)) map.put(key, map.get(key)+1);
			else map.put(key, (long)1);
		}
		Collection<Long> c = map.values();
		long MAX = Collections.max(c);
		List<Long> keys = new ArrayList<Long>(map.keySet());
		Collections.sort(keys);
		for(long i : keys) {
			if(map.get(i)==MAX) {
				System.out.println(i);
				break;
			}
		}
	}
}
