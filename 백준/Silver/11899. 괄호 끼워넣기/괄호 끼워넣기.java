import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import javax.print.attribute.standard.Copies;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().replace("()", "");
		int n = s.length()/2;
		for(int i=0; i<n; i++) {
			s = s.replace("()", "");
		}
		System.out.println(s.length());
	}
}