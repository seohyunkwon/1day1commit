import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		b:
		while(n-->0) {
			Stack<Character> vps = new Stack<Character>();
			String s = br.readLine();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='('){
					vps.push('(');
				} else {
					if(vps.isEmpty()) {
						System.out.println("NO");
						continue b;
					} else {
						vps.pop();
					}
				}
			}
			if(vps.size()>0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}