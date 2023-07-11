

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		String s = br.readLine();
		
		String result = Arrays.stream(br.readLine().split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
		int remain = 0;
		for(int i=0; i<result.length(); i++) {
			int n = result.charAt(i)-'0';
			remain += n%3;
			remain %= 3;
		}
		System.out.println(!result.contains("0")?-1:(remain==0?result:-1));
	}
}
