import java.io.*;
import java.util.*;

import javax.print.attribute.standard.Copies;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Stack<Double> st = new Stack<Double>();
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			switch (arr[i]) {
			case "+": st.push(st.pop()+st.pop()); break;
			case "-": st.push(-st.pop()+st.pop()); break;
			case "*": st.push(st.pop()*st.pop()); break;
			case "/": st.push(1/st.pop()*st.pop()); break;
			default: st.push(Double.parseDouble(arr[i]));break;
			}
		}
		while(!st.isEmpty()) {
			result+=st.pop();
		}
		System.out.println(result);
	}
}