import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=0; i<k; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			int a = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			int prev = -1;
			while(stack.size()!=0) {
				int m = stack.pop();
				if(m>prev) {
					prev = m;
					continue;
				}else {
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
		
	}
}