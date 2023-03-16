import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			if(a.equals("push")) {
				int b = Integer.parseInt(st.nextToken());
				stk.push(b);
			} else if(a.equals("pop")) {
				if(stk.isEmpty()) {
					System.out.println(-1);
				} else System.out.println(stk.pop());
			} else if(a.equals("size")) {
				System.out.println(stk.size());
			} else if(a.equals("empty")) {
				System.out.println(stk.isEmpty()?1:0);
			} else if(a.equals("top")) {
				if(stk.isEmpty()) System.out.println(-1);
				else System.out.println(stk.peek());
			}
			
		}
				
	
	}
}