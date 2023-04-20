import java.io.*;
import java.util.*;

import javax.print.attribute.standard.Copies;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");
		Stack<String> st1 = new Stack<String>();
		Stack<String> st2 = new Stack<String>();
		
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			switch (arr[i]) {
			case "L": st1.push(arr[i]); break;
			case "S": st2.push(arr[i]); break;
			case "R": if(!st1.isEmpty()) {st1.pop(); cnt++; break;} else {System.out.println(cnt); return;}
			case "K": if(!st2.isEmpty()) {st2.pop(); cnt++; break;} else {System.out.println(cnt);  return;}
			default: cnt++; break;
			}
		}
		System.out.println(cnt);
		
	}
}
