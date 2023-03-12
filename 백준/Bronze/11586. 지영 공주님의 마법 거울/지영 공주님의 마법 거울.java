import java.io.*;
import java.util.*;


class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	String[] arr = new String[n];
	for(int i=0; i<n; i++) {
		arr[i] = br.readLine();
		}
	int k = Integer.parseInt(br.readLine());
	if(k==1) {
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	} else if(k==2) {
		for(int i=0; i<n; i++) {
			StringBuffer sb = new StringBuffer(arr[i]);
			System.out.println(sb.reverse());
		}
	} else {
		for(int i=n-1; i>=0; i--) {
			System.out.println(arr[i]);
		}
	}
	
	}
}