import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(); int i = 1;
		while(!s.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int tmp = v%p;
			int remain = tmp>l?l:tmp;
			int result = l*(v/p)+remain;
			System.out.printf("Case %d: %d\n",i++,result);
			s=br.readLine();
		}
	}
}