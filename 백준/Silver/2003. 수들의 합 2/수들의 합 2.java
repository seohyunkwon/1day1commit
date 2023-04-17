import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int cnt = 0;
		int sum = arr[0];
		while(end<n) {
			if(sum>m) {
				sum-=arr[start];
				start++;
			} else if(sum<m) {
				end++;
				sum+=arr[end];
			} else {
				cnt++; end++;
				sum+=arr[end];
			}
		}
		System.out.println(cnt);
	}
}