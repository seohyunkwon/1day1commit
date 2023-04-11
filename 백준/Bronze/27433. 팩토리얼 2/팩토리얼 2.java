import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(getFactorial(n));
	
	}
	
	public static long getFactorial(int n) {
		if(n<=0) return 1;
		return n*getFactorial(n-1);
	}
}