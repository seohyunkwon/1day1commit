import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[1] = Long.parseLong(st.nextToken());
		for(int i=2; i<n+1; i++) {
			arr[i] = arr[i-1]+Long.parseLong(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(arr[b]-arr[a-1]);
		}
	
	}
}