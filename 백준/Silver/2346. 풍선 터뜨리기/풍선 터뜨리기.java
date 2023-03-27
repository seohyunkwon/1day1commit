import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Balloon> d = new ArrayDeque<Balloon>();
		int i = 1;
		while(st.hasMoreTokens()) {
			d.add(new Balloon(Integer.parseInt(st.nextToken()), i++));
		}
		while(d.size()>1) {
			Balloon b = d.poll();
			sb.append(b.idx).append(' ');
			int move = b.num;
			if(move>0) {
				move--;
				while(move-->0) {
					d.addLast(d.pollFirst());
				}
			} else {
				while(move++<0) {
					d.addFirst(d.pollLast());
				}
			}
		}
		System.out.println(sb.append(d.poll().idx));
	}
}
class Balloon{
	int num;
	int idx;
	Balloon(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}
}