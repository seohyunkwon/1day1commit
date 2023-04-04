import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!(s=br.readLine()).equals(".")) {
			Stack<Character> st = new Stack<Character>();
			boolean flag = true;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='(' || s.charAt(i)=='[') {
					st.add(s.charAt(i));
				} else if(s.charAt(i)==')') {
					if(st.isEmpty() || st.peek()!='(') {
						flag = false;
						break;
					} else {
						st.pop();
					}
				} else if(s.charAt(i)==']') {
					if(st.isEmpty()|| st.peek()!='[') {
						flag = false;
						break;
					} else {
						st.pop();
					}
					
				}
			}
			if(st.size()>0) flag=false;
			System.out.println(flag?"yes":"no");
		}
	}
}