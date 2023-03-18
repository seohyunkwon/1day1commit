import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] oj = new int[9];
		int[] sg = new int[9];
		boolean flag = false;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			oj[i]= Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			sg[i]= Integer.parseInt(st.nextToken());
		}
		int osum = 0; int ssum = 0;
		
		for(int i=0; i<9; i++) {
			osum += oj[i];
			if(osum>ssum) {
				ssum += sg[i];
				if(osum<ssum) flag = true;
			} else {
				ssum+=sg[i];
			}
			
		}
		System.out.println(flag?"Yes":"No");
	}
}