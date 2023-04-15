import java.io.*;
import java.util.*;

import javax.imageio.IIOImage;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int i = 0;
		for(int j=0; j<10; j++) {
			int n =Integer.parseInt(br.readLine());
			arr[j] = n;
		}
		for(int j = 1; j<10; j++) {
			arr[j] = arr[j-1]+arr[j];
		}
		for(i = 0; i<10; i++) {
			if(arr[i]>=100) break;
		}
		if(i==0 || i==10) {
			if(i==10) i--;
			System.out.println(arr[i]);
			return;
		}
		int result = Math.abs(arr[i]-100)>Math.abs(arr[i-1]-100)?arr[i-1]:arr[i];
		System.out.println(result);
	}
}