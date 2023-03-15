import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k!=0) {
				st.push(k);
			} else {
				st.pop();
			}
		
		}
		int sum=0;
		while(!st.isEmpty()) {
			sum+=st.pop();
		}
		System.out.println(sum);
	
	
	}
}