import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				set.remove(s); 
			} 
			set.add(s);
		}
		set.stream().limit(n).forEach(System.out::println);
	}
}
