import java.io.*;
import java.util.*;

import javax.security.auth.kerberos.KerberosKey;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int start = 0;
			int end = n-1;
			while(start<end) {
				if(arr[start]+arr[end]<arr[i]) {
					start++;
				} else if(arr[start]+arr[end]>arr[i]) {
					end--;
				} else {
					if(start!=i && end!=i) {
						cnt++; break;
					} else if(start==i) start++;
					else if(end==i) end--;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
