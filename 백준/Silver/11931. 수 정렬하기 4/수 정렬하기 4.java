import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[2000001];
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())+1000000] = true;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i]) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
	
	
	}
}