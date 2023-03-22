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
		
		int[] arr = new int[m+1];
		
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
		
		for(int i=n;i<arr.length; i++) {
			sb.append(arr[i]>0?i+"\n":"");
		}
		
		System.out.println(sb);
		
	
	
	
	}
}