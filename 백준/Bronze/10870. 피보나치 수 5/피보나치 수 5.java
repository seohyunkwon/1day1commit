import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(getFibonacci(n));
	}
	public static long getFibonacci(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		return getFibonacci(n-1)+getFibonacci(n-2);
	}
}