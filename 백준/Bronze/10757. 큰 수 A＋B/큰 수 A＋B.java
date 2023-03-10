import java.io.*;
import java.util.*;

class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	String a = st.nextToken();
	String b = st.nextToken();
	String lz; String sm;
	if(a.length()>b.length()) {lz = a; sm = b;}
	else {lz=b; sm = a;}
	int[] arr1 = new int[lz.length()];
	int[] arr2 = new int[lz.length()];
	int k = lz.length()-sm.length(); int j=0;
	for(int i=0; i<arr1.length; i++) {
		arr1[i]=lz.charAt(i)-'0';
		if(i<k) {arr2[i]=0;}
		else {arr2[i]=sm.charAt(j++)-'0';}
	}
	for(int i=arr1.length-1; i>0; i--) {
		if(arr1[i]+arr2[i]>=10) {
			arr1[i-1]+=1;
			arr1[i]-=10;
		}
		arr1[i]+=arr2[i];
	}
	arr1[0]+=arr2[0];

	for(int i=0; i<arr1.length; i++) {
		System.out.print(arr1[i]);
	}
	
	}
}
