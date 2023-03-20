import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push_front": deque.addFirst(Integer.parseInt(st.nextToken())); break;
			case "push_back": deque.addLast(Integer.parseInt(st.nextToken())); break;
			case "pop_front": sb.append(deque.isEmpty()?-1:deque.pollFirst()).append('\n'); break;
			case "pop_back": sb.append(deque.isEmpty()?-1:deque.pollLast()).append('\n'); break;
			case "size" : sb.append(deque.size()).append('\n'); break;
			case "empty" : sb.append(deque.isEmpty()?1:0).append('\n'); break;
			case "front" : sb.append(deque.isEmpty()?-1:deque.getFirst()).append('\n'); break;
			case "back" : sb.append(deque.isEmpty()?-1:deque.getLast()).append('\n'); break;
			}
		}
		System.out.println(sb);
	
	}
}