import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("===괄호 검사 프로그램===");
		System.out.print("수식을 입력하세요 => ");
		System.out.println(matchCase(br.readLine())?"일치합니다":"불일치합니다");
	}
	static boolean matchCase(String s) {
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				st.push('(');
			} else if(s.charAt(i)==')') {
				if(!st.isEmpty()) st.pop();
				else return false;
			}
		}
		if(st.size()==0) return true;
		else return false;
		
	}
}
