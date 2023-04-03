import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		int i=1;
		for(i=1; i<list.get(0).length(); i++) {
			HashSet<String> set = new HashSet<String>();
			for(String s:list) {
				String key = s.substring(s.length()-i);
				set.add(key);
			}
			if(set.size()==n) break;
		}
		System.out.println(i);
		
	}
}
