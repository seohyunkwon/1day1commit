import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n<=2) {
			System.out.println(n!=2?n:1);
			return;
		}
		long result = 0;
		long a = 0;
		long b = 1;
		while(n>=2) {
			result = a+b;
			long tmp = b;
			a = b;
			b = result;
			n--;
		}
		System.out.println(result);
	}
}