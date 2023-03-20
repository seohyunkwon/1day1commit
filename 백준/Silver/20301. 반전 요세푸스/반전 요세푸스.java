import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			deque.offer(i);
		}
		
		int cnt=0, mcn=0;
		while(deque.size()>1) {
			if(cnt%m==0 && cnt/m>0) mcn++;
			if(mcn%2==0) {
				for(int i=0; i<k-1; i++) {
					deque.offer(deque.poll());
				}
				sb.append(deque.poll()).append('\n');
				cnt++;
			} else {
				for(int i=0; i<k-1; i++) {
					deque.offerFirst(deque.pollLast());
				}
				sb.append(deque.pollLast()).append('\n');
				cnt++;
			}
		}
		System.out.println(sb.append(deque.poll()));
		
	}
}