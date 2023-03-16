import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		int last = -1;
		for(int i=0; i<n; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			String st = s.nextToken();
			if(st.equals("push")) {
				last = Integer.parseInt(s.nextToken());
				q.offer(last);
			} else if(st.equals("pop")) {
				System.out.println(q.isEmpty()?-1:q.poll());
			} else if(st.equals("size")) {
				System.out.println(q.size());
			} else if(st.equals("empty")) {
				System.out.println(q.isEmpty()?1:0);
			} else if(st.equals("front")) {
				System.out.println(q.isEmpty()?-1:q.peek());
			} else if(st.equals("back")) {
				System.out.println(q.isEmpty()?-1:last);
			}
		}
		
	}
}