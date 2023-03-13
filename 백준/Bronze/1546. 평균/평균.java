
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
			int num=0;
			while(st.hasMoreTokens()) {
				arr[num] = Integer.parseInt(st.nextToken());
				num++;
			}
		
		Arrays.sort(arr);
		
		int sum=0;
		
		for(int i=0; i<n; i++) {
			sum+=arr[i];
		}
		
		double avg = sum/(double)n;
		
		System.out.println((avg/arr[n-1])*100);
	}
}