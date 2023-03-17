import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();
		Integer[] result = new Integer[s.length()];
		for(int i=0; i<arr.length; i++){
			result[i] = arr[i]-'0';
		}
		Arrays.sort(result,Collections.reverseOrder());
		for(int i: result){
			System.out.print(i);
		}
	}
}
