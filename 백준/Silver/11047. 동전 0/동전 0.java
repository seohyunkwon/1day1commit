import java.io.*;
import java.util.*;

class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	int cnt=0;
	int[] money = new int[n];
	for(int i=0; i<n; i++) {
		money[i]=Integer.parseInt(br.readLine());
	}
	int min = 0;
	for(int i=n-1; i>=0; i--) {
		if(money[i]<=k) {min = i; break;}
	}
	for(int i=min; i>=0; i--) {
		cnt+= k/money[i];
		k %= money[i];
		if(k==0) break;
	}
	System.out.println(cnt);
	}
}