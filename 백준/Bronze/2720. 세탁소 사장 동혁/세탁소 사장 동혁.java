import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = {25,10,5,1};
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			int t = Integer.parseInt(br.readLine());
			for(int j=0; j<arr.length; j++) {
				sb.append(t/arr[j]+" ");
				t=t%arr[j];
			}
			System.out.println(sb);
		}
	
	}
}