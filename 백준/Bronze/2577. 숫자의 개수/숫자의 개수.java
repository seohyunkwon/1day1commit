import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		long multi = a*b*c;
		String s = String.valueOf(multi);
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'0']+=1;
		}
		for(int i: arr) {
			System.out.println(i);
		}
	}
}