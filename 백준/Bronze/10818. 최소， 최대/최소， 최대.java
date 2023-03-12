import java.io.*;
import java.util.*;


class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Integer> list = new ArrayList<Integer>();
	int n = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());
	while(st.hasMoreTokens()) {
		list.add(Integer.parseInt(st.nextToken()));
	}
	
	System.out.println(Collections.min(list)+" "+Collections.max(list));

	}
}
