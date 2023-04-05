import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] range = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			range[i] = i+1;
		}
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		int k=0;
		st.add(0); 
		for(int i=0; i<n; i++) {
			if(arr[i]>st.peek()) {
				while(st.peek()<arr[i]) {
					st.push(range[k]);
					k++;
					sb.append("+").append("\n");
				}
				st.pop();
				sb.append("-").append("\n");
			} else if(arr[i]==st.peek()) {
				st.pop();
				sb.append("-").append("\n");
			} else if(arr[i]<st.peek()) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	
	}
}