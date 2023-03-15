import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> st = new Stack<String>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String answer ="";
			StringTokenizer stn = new StringTokenizer(br.readLine());
			while(stn.hasMoreTokens()) {
				st.push(stn.nextToken());
			}
			while(!st.isEmpty()) {
				answer +=st.pop()+" ";
			}
			System.out.println("Case #"+(i+1)+": "+answer.trim());
		}
	
	
	}
}