import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=n; i<=m; i++) {
			int cnt=0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) cnt++;
			}
			if(cnt%2==1) {
				sum+=i;
				list.add(i);
			}
		}
		if(sum==0) {System.out.println(-1); return;}		
		System.out.println(sum);
		System.out.println(Collections.min(list));
	
	}
}