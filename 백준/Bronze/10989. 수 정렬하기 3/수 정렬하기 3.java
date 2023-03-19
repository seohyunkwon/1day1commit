import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10000];
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())-1]+=1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i]; j++) {
				sb.append(i+1).append("\n");
			}
		}
		System.out.println(sb);
	
	
	}
}