import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		long[] prepix = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if(i==0) prepix[i] = arr[i];
			else prepix[i] = arr[i]+prepix[i-1];
		}
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum+= arr[i] * (prepix[n-1]-prepix[i]);
		}
		System.out.println(sum);
	
	}
}