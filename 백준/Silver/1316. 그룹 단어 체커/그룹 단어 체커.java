
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=0; i<n; i++) {
			
			String s = br.readLine();
			boolean[] arr = new boolean [26];
			boolean tmp = true;
			for(int j=0; j<s.length(); j++) {
				int index = s.charAt(j)-'a';
				if(arr[index]) {
					if(s.charAt(j)!=s.charAt(j-1)) {
						tmp = false;
						break;
					}
					
				} else {
					arr[index] = true;
				}
			}
			if(tmp) cnt++;
			
		}
		System.out.println(cnt);
	}
}
