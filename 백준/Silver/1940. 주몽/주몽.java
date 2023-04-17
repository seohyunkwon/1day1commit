import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		int cnt = 0;
		while(end>=0 && start<n && start<end) {
			int k = arr[start]+arr[end];
			if(k == m) {
				cnt++;
				end--;
			} else if(k<m) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(cnt);
	}
}