import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import javax.print.attribute.standard.Copies;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			Stack<Integer> st = new Stack<Integer>();
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			st.push(arr[1]);
			int cnt = 0;
			for(int j=2; j<=12; j++) {
				if(st.peek()<arr[j]) {
					st.push(arr[j]);
				} else if(st.peek()>arr[j]) {
					while(st.peek()>arr[j]) {
						st.pop();
						cnt++;
					}
					if(st.peek()<arr[j]) st.push(arr[j]);
				} 
			}
			System.out.println(i+" "+cnt);
		}
	}
}
