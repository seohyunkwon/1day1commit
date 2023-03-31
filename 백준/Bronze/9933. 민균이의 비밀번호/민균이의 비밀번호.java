import java.io.*;
import java.util.*;
class Main{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<n; i++) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder(s);
			String s2 = sb.reverse().toString();
			if(s.equals(s2)) {
				System.out.println(s.length()+" "+s.charAt(s.length()/2));
			}else if(set.contains(s) || set.contains(s2)) {
				System.out.println(s.length()+" "+s.charAt(s.length()/2));
			} else set.add(s);
		}
	
	}
}
