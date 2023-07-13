import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		for(int j=0; j<n-1; j++) {
			String tmp = br.readLine();
			int m = 0;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(tmp.contains(c+"")) {
					tmp = tmp.replaceFirst(c+"", "");
				} else {
					m++;
				}
			}

			if(tmp.length()==m && m==1) cnt++;
			else if (tmp.length()+m<2) cnt++; 
		}
		System.out.println(cnt);
	}                                                                      
}
