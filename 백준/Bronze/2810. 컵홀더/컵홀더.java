import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = br.readLine().replaceAll("LL", "s").length()+1;
		System.out.println(n>cnt?cnt:n);
		 
	}
}
