import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		if(s.contains("1")&&s.contains("0")) {
			StringTokenizer st = new StringTokenizer(s, "1");
			int onecnt = st.countTokens();
			st = new StringTokenizer(s, "0");
			int zerocnt = st.countTokens();
			cnt = Math.min(onecnt, zerocnt);
		}
		System.out.println(cnt);
			
		
		
	}
}
