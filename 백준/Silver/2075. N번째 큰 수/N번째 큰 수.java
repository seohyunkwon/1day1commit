import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				if(pq.size()<n) {
					pq.add(Integer.parseInt(st.nextToken()));
				} else {
					int k = Integer.parseInt(st.nextToken());
					if(k>pq.peek()) {
						pq.poll();
						pq.add(k);
					}
				}
			}
		}
		System.out.println(pq.peek());
	}
}
