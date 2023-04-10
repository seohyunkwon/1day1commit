
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		while(true) {
			st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if(n==-1) System.exit(0);
		
		int sum=0;
		String answer = "";
		for(int i=1; i<n; i++) {
			if(n%i==0) {
				sum+=i;
				answer+=i+" + ";
			}
		}
		StringBuffer sb = new StringBuffer(answer);
		String result=sb.substring(0, answer.length()-3);
		if(n==sum) {
			System.out.println(n+" = "+result);
			
		} else {
			System.out.println(n+" is NOT perfect.");
		}
		}
	}
}
