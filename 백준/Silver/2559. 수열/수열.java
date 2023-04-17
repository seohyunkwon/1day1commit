import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		int tmp = Integer.MIN_VALUE;
		for(int i=n; i>=k; i--) {
			tmp = Math.max(tmp, arr[i]-arr[i-k]);
		}
		System.out.println(tmp);
	}
}