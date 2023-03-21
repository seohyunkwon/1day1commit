import java.util.*;
import java.io.*;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[2001];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken());
			arr[m+1000]=true;
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]) {
				sb.append(i-1000).append(' ');
			}
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}