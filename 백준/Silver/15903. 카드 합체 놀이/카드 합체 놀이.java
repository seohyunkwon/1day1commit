import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(long i=0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		for(long i=0; i<m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			pq.add(a+b);
			pq.add(a+b);
		}
		long sum = pq.stream().mapToLong(i->i).sum();
		System.out.println(sum);
		
		
	}
}
