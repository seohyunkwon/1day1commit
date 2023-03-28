import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.equals("0")) {
				sb.append(pq.size()==0?-1:pq.poll()).append('\n');
			} else {
				StringTokenizer st = new StringTokenizer(s);
				int k = Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens()) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
				
			}
		}
		System.out.println(sb);
		
		
	}
}
