import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int j=0; j<n; j++) {
			HashSet<String> set = new HashSet<String>();
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++) {
				set.add(br.readLine());
			}
			System.out.println(set.size());
		}
	}
}