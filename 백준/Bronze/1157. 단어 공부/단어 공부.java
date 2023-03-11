import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = new String(br.readLine());
		st = st.toUpperCase();
		int[] arr = new int[26];
		for(int i=0; i<st.length(); i++) {
			arr[st.charAt(i)-'A'] ++;
		}
		int max = -1; int count = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) { max = arr[i]; count = i+1; }
		}
		Arrays.sort(arr);
		if(arr[25]==arr[24]) System.out.println("?");
		else {
			char result = (char)(count+64);
			System.out.println(result);
		}
		
		
	
	}
}
