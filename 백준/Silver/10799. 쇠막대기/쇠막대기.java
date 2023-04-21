import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String s = br.readLine();
		stack.push(s.charAt(0));
		int cnt = 0;
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i)==')') {
				if(s.charAt(i-1)=='(') {
					stack.pop();
					cnt+=stack.size();
				} else {
					stack.pop();
					cnt++;
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		System.out.println(cnt);
	}
}