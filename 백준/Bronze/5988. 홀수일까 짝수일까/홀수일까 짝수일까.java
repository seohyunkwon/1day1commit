import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			int m = s.charAt(s.length()-1);
			System.out.println(m%2==0?"even":"odd");
					
		}
	}
}