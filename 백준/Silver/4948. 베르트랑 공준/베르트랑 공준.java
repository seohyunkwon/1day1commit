import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n; 
		while((n=Integer.parseInt(br.readLine()))!=0) {
			int[] arr = new int[n*2+1];
			for(int i=2; i<arr.length; i++) {
				arr[i]=i;
			}
			
			for(int i=2; i<arr.length; i++) {
				if(arr[i]==0) continue;
				else {
					for(int j=2*i; j<arr.length; j+=i) {
						arr[j]=0;
					}
				}
			}
			int cnt = 0;
			for(int i=n+1; i<arr.length; i++) {
				cnt+=arr[i]>0?1:0;
			}
			System.out.println(cnt);
			
		}
	
	}
}