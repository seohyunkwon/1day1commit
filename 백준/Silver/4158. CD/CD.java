import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0; i<n; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}
			int cnt = 0;
			for(int i=0; i<m; i++) {
				if(set.contains(Integer.parseInt(br.readLine()))) cnt++;
			}
			System.out.println(cnt);
		}
			
	}
}
