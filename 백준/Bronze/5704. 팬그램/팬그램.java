import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!"*".equals(s=br.readLine())) {
			boolean[] arr = new boolean[26];
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)!=' ')
				arr[s.charAt(i)-'a'] = true;
			}
			boolean flag = true;
			
			for(boolean b : arr) {
				if(b==false) {
					flag = false; break;
				}
			}
			
			System.out.println(flag?"Y":"N");
			
		}
		
		
	}
}