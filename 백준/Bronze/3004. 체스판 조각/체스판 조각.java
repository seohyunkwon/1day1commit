import java.io.*;

class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int answer = (n/2+1)*((n%2==0)?(n/2+1):(n/2+2));
	System.out.println(answer);

	
	
	}
}
