
import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=0; i<n; i++) {
			ArrayList<Character> list = new ArrayList<Character>();		
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				if(list.contains(s.charAt(j))) {
					if(s.charAt(j)==s.charAt(j-1)) {
						list.add(s.charAt(j));
					} else {
						list.add(s.charAt(j));
						break;
					}
				} else {
					list.add(s.charAt(j));
				}
				if(j==s.length()-1)cnt++;
			}

		}
		System.out.println(cnt);
	}
}
