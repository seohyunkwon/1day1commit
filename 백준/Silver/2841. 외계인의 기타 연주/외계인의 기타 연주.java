import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Stack<Integer>> list = new ArrayList<Stack<Integer>>();
		for(int i=0; i<6; i++) {
			list.add(new Stack<Integer>());
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken());
			if(list.get(k).isEmpty() || list.get(k).peek()<j) {
				cnt++;
				list.get(k).push(j);
			} else if(list.get(k).peek()>j){
				while(!list.get(k).isEmpty() && list.get(k).peek()>j) {
					cnt++;
					list.get(k).pop();
				}
				if(list.get(k).isEmpty() || list.get(k).peek()!=j) {cnt++; list.get(k).push(j);}
			} 
		}
		System.out.println(cnt);
	}
}