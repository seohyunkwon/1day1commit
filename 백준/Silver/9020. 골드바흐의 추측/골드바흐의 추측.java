import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int o=0; o<t; o++) {
			int n=Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			for(int i=2; i<arr.length; i++) {
				arr[i]=i;
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=2; i<arr.length; i++) {
				if(arr[i]==0) continue;
				for(int j=2*i; j<arr.length; j+=i) {
					arr[j]=0;
				}
			}
			for(int i=2; i<arr.length; i++) {
				if(arr[i]>0) list.add(i);
			}
			int[] arr2 = new int[list.size()]; int x=0;
			for(int i:list) {
				arr2[x++]=i;
			}
			int a=0, b=0; int abs = Integer.MAX_VALUE;
			for(int i=0; i<arr2.length; i++) {
				for(int j=i; j<arr2.length; j++) {
					if(arr2[j]+arr2[i]==n) {
						if(arr2[j]-arr2[i]<abs) {
							a=arr2[i]; b=arr2[j];
							abs = b-a;
						}
					}
				}
			}
			System.out.println(a+" "+b);
		}
	
	}
}