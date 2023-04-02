import java.io.*;
import java.util.*;
class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==-1) break;
			if(n==0 && ! q.isEmpty()) q.poll();
			else if(q.size()<size) {
					q.add(n);
			}
		}
		if(q.isEmpty()) {
			sb.append("empty");
		} else {
			while(!q.isEmpty()) {
				sb.append(q.poll()+" ");
			}
		}
		System.out.println(sb);
	}
}
