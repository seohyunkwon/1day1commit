import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int n = s1.length();
		String s2 = br.readLine();
		int m = s2.length();
		String[] arr = s1.split(s2);
		int sum = Arrays.stream(arr).mapToInt(String::length).reduce(0,  (a,b)->a+b);
		System.out.println((n-sum)/m);
	
	}
}
