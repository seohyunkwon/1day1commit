import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[2000001];
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())+1000000] += 1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i]; j++) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
	
	
	}
}