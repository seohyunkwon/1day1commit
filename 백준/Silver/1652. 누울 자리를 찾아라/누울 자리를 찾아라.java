import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		int cntX = 0;
		int cntY = 0;
		for(int i=0; i<n; i++) {
			String[] tmp_arr = arr[i].split("X");
			for(String s:tmp_arr) {
				if(s.contains("..")) {
					cntX++;
				}
			}
			String tmp = "";
			for(int j=0; j<n; j++) {
				tmp+=arr[j].charAt(i);
			}
			tmp_arr = tmp.split("X");
			for(String s:tmp_arr) {
				if(s.contains("..")) cntY++;
			}
		}
		System.out.println(cntX+" "+cntY);
	}
}

      