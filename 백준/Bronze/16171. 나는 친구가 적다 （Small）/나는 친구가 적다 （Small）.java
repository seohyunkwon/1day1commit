import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine().replaceAll("[1,2,3,4,5,6,7,8,9,0]", "");
		String s2 = br.readLine();
		System.out.println(s1.contains(s2)?1:0);
	}
}