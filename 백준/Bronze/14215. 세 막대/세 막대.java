import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		HashSet<Integer> set = new HashSet<Integer>();
		int sum=0;
		for(int i=0; i<3; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			set.add(arr[i]);
			sum+=arr[i];
		}
		Arrays.sort(arr);
		
		System.out.println(set.size()==1?arr[0]*3:arr[0]+arr[1]>arr[2]?sum:2*(arr[0]+arr[1])-1);
	}
}
