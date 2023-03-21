import java.util.*;
import java.io.*;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		HashSet<Integer> a = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int k = Integer.parseInt(st.nextToken());
			cnt+=a.contains(k)?1:0;
		}
		
		bw.append(n+m-cnt*2+"");
		bw.flush();
		bw.close();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
}