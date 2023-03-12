import java.io.*;
import java.util.*;


class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = br.readLine();
	while(s.length()>10) {
		System.out.println(s.substring(0, 10));
		s = s.substring(10);
	}
	System.out.println(s);
	}
}
