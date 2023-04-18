import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long ke = 0;
		int[] arr = new int[1000001];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b] = a;
			ke+=a;
		}
		if(k>1000000) {
			System.out.println(ke);
			return;
		}
		int range = k*2;
		long sum = 0;
		for(int i=0; i<range; i++) {
			sum+=arr[i];
		}
		long max = sum;
		for(int i=1; i<arr.length-range-1; i++) {
			sum = sum+arr[range+i]-arr[i-1];
			max = sum>max?sum:max;
		}
		System.out.println(max);
	}
}