import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n*2-1; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
			} else map.put(name, 0);
		}
		List<String> list = new ArrayList<String>(map.keySet());
		for(String s:list) {
			if(map.get(s)%2==0) {
				System.out.println(s);
			}
		}
	}
}