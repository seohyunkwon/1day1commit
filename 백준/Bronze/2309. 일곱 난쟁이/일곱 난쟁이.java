import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9]; int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		int a = -1; int b = -1;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-arr[i]-arr[j]==100) {
					a = i; b = j;
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(i!=a && i!=b) {
				System.out.println(arr[i]);
			}
		}
	}
}