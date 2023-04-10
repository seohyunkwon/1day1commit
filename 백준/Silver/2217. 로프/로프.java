import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		int cnt = 1;
		for(int i=arr.length-1; i>=0; i--) {
			int max = arr[i] * cnt;
			result = Math.max(result, max);
			cnt++;
		}
		
		System.out.println(result);
	
	}
}
