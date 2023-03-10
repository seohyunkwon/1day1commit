import java.io.*;
import java.util.*;

class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	StringTokenizer st;
	for(int i=0; i<t; i++) {
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int x = n%h==0? h:n%h;
		int y = n%h>0? n/h+1:n/h;
		System.out.printf("%d%02d\n",x,y);
	}
	}
}

