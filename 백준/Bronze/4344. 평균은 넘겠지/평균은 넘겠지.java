
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[st.countTokens()];
			int sum=0; int num = 0;
			while(st.hasMoreTokens()) {
				arr[num] = Integer.parseInt(st.nextToken());
				if(num>0) { sum+=arr[num]; }
				num++;
			}
			double avg = sum/(double)arr[0];
			int count=0;
			for(int j=1; j<arr.length; j++) {
				if(arr[j]>avg) {count++;}
			}
			double a = count/(double)(arr.length-1)*100;
			double result= Math.round(a*1000)/1000.0;
			System.out.printf("%.3f%%\n",result);
			
			}

	}
}
