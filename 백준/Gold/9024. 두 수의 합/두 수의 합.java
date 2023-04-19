import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int start = 0;
			int end = arr.length-1;
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			while(start<end) {
				int tmp = arr[start]+arr[end];
				if(tmp<k) {
					start++;
				} else if(tmp>k) {
					end--;
				} else {
					start++;
					end--;
				}
				if(Math.abs(tmp-k)<min) {
					min = Math.abs(tmp-k);
					cnt = 1;
				} else if(Math.abs(tmp-k)==min) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
