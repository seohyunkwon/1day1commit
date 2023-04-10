import java.io.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = n/5;
		int cnt = 0;
		for(int i=m; i>=0 ;i--) {
			int tmp = n-(i*5);
			if(tmp%2==0) {
				cnt = i + tmp/2;
				break;
			}
		}
		if(cnt == 0 ) cnt =-1;
		System.out.println(cnt);
		
	}
}
