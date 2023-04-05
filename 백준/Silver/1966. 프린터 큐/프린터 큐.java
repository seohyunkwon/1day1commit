import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<int[]> q = new LinkedList<int[]>();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				q.add(new int[] {a, j}); 
			}
			int[] arr = q.stream().mapToInt(array->array[0]).sorted().toArray();
			int cnt = 0; int k = arr.length-1;
			while(q.size()>0) {
				if(arr[k]==q.peek()[0]) {
					cnt++;
					if(q.peek()[1]==m) break;
					q.poll();
					k--;
				} else {
					q.offer(q.poll());
				}
			}
			System.out.println(cnt);
			
		}
	
	}
}