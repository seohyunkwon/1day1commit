
import java.util.*;
import java.io.*;


class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 		String s = br.readLine();
		boolean flag = false;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			if(flag && s.charAt(i)!='>') sb.append(s.charAt(i));
			else if(s.charAt(i)==' ') {
				while(stack.size()>0) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			} else if(s.charAt(i)=='<') {
				while(stack.size()>0) {
					sb.append(stack.pop());
				}
				sb.append('<'); flag=true;
			} else if(s.charAt(i)=='>') {
				sb.append('>'); flag=false;
			} else {
				stack.add(s.charAt(i));
			}
		}
		while(stack.size()>0) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
