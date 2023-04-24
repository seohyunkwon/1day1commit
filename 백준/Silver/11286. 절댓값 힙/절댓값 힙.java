import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->Math.abs(a)!=Math.abs(b)?Math.abs(a)-Math.abs(b):a-b);
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			if(m!=0) pq.offer(m);
			else {
				sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}

      