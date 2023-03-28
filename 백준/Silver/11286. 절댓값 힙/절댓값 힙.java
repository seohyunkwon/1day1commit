import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Math.abs(a)!=Math.abs(b)?Math.abs(a)-Math.abs(b):a-b);
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.equals("0")) {
				sb.append(pq.isEmpty()?0:pq.poll()).append('\n');
			} else pq.add(Integer.parseInt(s));
		}
		System.out.println(sb);
		
		
	}
}
