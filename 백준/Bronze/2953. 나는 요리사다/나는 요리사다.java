
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = -1; int index = -1;
		for(int i=1; i<=5; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				sum+=Integer.parseInt(st.nextToken());
			}
			if(max<sum) {
				max= sum; index = i;
			}
		}
		System.out.println(index + " " + max);
		
	}
}