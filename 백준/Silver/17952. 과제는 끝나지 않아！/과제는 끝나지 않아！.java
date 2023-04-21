import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> score = new Stack<Integer>();
		Stack<Integer> time = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("1")) {
				score.add(Integer.parseInt(st.nextToken()));
				int j = Integer.parseInt(st.nextToken())-1;
				if(j==0) sum+=score.pop();
				else time.add(j);
			} else {
				if(time.isEmpty()) continue;
				int k = time.pop()-1;
				if(k<1) sum+=score.pop();
				else time.add(k);
			}
		}
		System.out.println(sum);
	
	}
}