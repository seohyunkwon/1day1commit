import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int p1 = b-a-1;
			int p2 = c-b-1;
			System.out.println(Math.max(p1, p2));
			
		}
		sc.close();
	}
}
