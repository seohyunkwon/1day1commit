import java.io.*;
import java.util.*;


class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	for(int i=1; i<=9; i++) {
		System.out.println(n+" * "+ i +" = "+(n*i));
	}


	}
}