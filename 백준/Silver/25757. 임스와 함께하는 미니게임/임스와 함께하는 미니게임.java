import java.io.*;
import java.util.*;

class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	HashSet<String> set = new HashSet<String>();
	int n = Integer.parseInt(st.nextToken());
	String k = st.nextToken();
	for(int i=0; i<n; i++) {
		set.add(br.readLine());
	}
	
	if(k.equals("Y")) System.out.println(set.size());
	else if(k.equals("F")) System.out.println(set.size()/2);
	else if(k.equals("O")) System.out.println(set.size()/3);
	
	
	}
}
