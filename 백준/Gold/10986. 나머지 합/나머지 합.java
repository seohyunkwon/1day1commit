import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long cnt = 0;
		long[] prefix = new long[n];
		long[] arr = new long[m];
		st = new StringTokenizer(br.readLine());
		prefix[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) {
			prefix[i] = prefix[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			int r = (int) (prefix[i]%m);
			if(r==0) cnt++;
			arr[r]++;
		}
		for(int i=0; i<m; i++) {
			if(arr[i]>1) cnt+=arr[i]*(arr[i]-1)/2;
		}
		System.out.println(cnt);
	
	}
}