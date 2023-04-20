import java.io.*;
import java.util.*;

import javax.print.attribute.standard.Copies;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=0; i<n; i++) {
			Stack<String> st = new Stack<String>();
			String[] arr = br.readLine().split("");
			st.push(arr[0]);
			for(int j=1; j<arr.length; j++) {
				if(st.isEmpty()) {
					st.push(arr[j]);
					continue;
				}
				if(st.peek().equals(arr[j])) st.pop();
				else st.push(arr[j]);
			}
			
			if(st.isEmpty()) cnt++;
		}
		System.out.println(cnt);
	}
}
