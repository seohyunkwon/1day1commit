import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		for(int i=2; i<arr.length; i++) {
			arr[i]=i;
		}
		int cnt = 0;
		for(int i=2; i<arr.length; i++) {
			if(arr[i]==0) continue; 
			for(int j=i; j<arr.length; j+=i) {
				if(arr[j]==0) continue;
				arr[j]=0; cnt++;
				if(cnt==m) {
					System.out.println(j); break;
				}
			}
		}
	
	}
}
