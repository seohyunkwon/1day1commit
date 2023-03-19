import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int last = -1;
		for(int i=0; i<n; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			String st = s.nextToken();
			if(st.equals("push")) {
				last = Integer.parseInt(s.nextToken());
				q.offer(last);
			} else if(st.equals("pop")) {
				sb.append(q.isEmpty()?-1:q.poll()).append('\n');
			} else if(st.equals("size")) {
				sb.append(q.size()).append('\n');
			} else if(st.equals("empty")) {
				sb.append(q.isEmpty()?1:0).append('\n');
			} else if(st.equals("front")) {
				sb.append(q.isEmpty()?-1:q.peek()).append('\n');
			} else if(st.equals("back")) {
				sb.append(q.isEmpty()?-1:last).append('\n');
			}
		}
		System.out.println(sb);
	}
}