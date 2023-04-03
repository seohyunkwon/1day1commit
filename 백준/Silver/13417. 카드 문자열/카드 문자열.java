import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Character> q = new LinkedList<Character>();
			for(int j=0; j<n; j++) {
				q.add(st.nextToken().charAt(0));
			}
			
			char prev = q.poll();
			sb.append(prev);
			while(q.size()>0) {
				if(prev>=q.peek()) {
					sb.insert(0, q.peek());
					prev = q.poll();
				} else {
					sb.append(q.poll());
					
				}
			}
			System.out.println(sb);
		}
	}
}
