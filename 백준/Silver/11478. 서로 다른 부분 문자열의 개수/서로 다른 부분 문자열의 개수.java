import java.util.*;
import java.io.*;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<s.length(); i++) {
			set.add(String.valueOf(s.charAt(i)));
		}
		for(int j=2; j<=s.length(); j++) {
			for(int i=0; i<s.length()-j+1; i++) {
				set.add(s.substring(i, i+j));
			}
		}
		bw.append(String.valueOf(set.size()));
		bw.flush();
		bw.close();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
}
