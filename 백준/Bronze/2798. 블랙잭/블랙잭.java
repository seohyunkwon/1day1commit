import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cha = Integer.MAX_VALUE;
		int sum = -1;
		for(int i=0; i<n-2; i++) {
			for(int j = i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					if(Math.abs(arr[i]+arr[j]+arr[k]-m)<cha) {
						if(arr[i]+arr[j]+arr[k]<=m) {
							cha = Math.abs(arr[i]+arr[j]+arr[k]-m);
							sum = arr[i]+arr[j]+arr[k];
						}
					}
				}
			}
		}

		System.out.println(sum);
	}
}