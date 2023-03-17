import java.util.*;
import java.io.*;
import java.sql.Blob;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ArrayList<Integer> aNum = new ArrayList<Integer>();
		ArrayList<Integer> bNum = new ArrayList<Integer>();
		for(int i=1; i<=a; i++) {
			if(a%i==0) aNum.add(i);
		}
		for(int i=1; i<=b; i++) {
			if(b%i==0) bNum.add(i);
		}
		ArrayList<Integer> min = (ArrayList<Integer>)aNum.clone();
		
		min.retainAll(bNum);
		int m = Collections.max(min);
		System.out.println(m);
		System.out.println(a/m*b/m*m);
		
	}
}