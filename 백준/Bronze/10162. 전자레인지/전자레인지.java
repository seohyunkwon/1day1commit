import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int[] arr = {300,60,10};
		if(n%10!=0) { System.out.println(-1); return; }
		for(int i=0; i<arr.length; i++) {
			if(n/arr[i]==0) {
				sb.append(0).append(" ");
				continue;
			}
			int cnt = n/arr[i];
			n = n-cnt*arr[i];
			sb.append(cnt).append(" ");
		}
		System.out.println(sb);
	}
}