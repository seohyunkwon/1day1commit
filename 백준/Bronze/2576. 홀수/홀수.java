import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main (String[] args) throws IOException{
		int[] arr = new int[7];
		int[] arr2 = new int[7];
		int n=0; int sum=0; 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<7; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		for(int i=0; i<7; i++) {
			if(arr[i]%2!=0) {arr2[n]=arr[i];
			n++; sum+=arr[i];}
		}
		if(arr2[0]==0) {
			System.out.println("-1");
		} else{
			int min=arr2[0];
		
			for(int i=0; i<7; i++) {
				if(arr2[i]==0) break;
				if(arr2[i]<min) min=arr2[i];
			}
				
			System.out.println(sum);
			System.out.println(min);
			}
		
	}
}
