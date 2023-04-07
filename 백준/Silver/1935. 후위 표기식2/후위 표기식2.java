import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] num = new double[n];
		char[] arr = br.readLine().toCharArray();
		Stack<Double> st = new Stack<Double>();
		for(int i=0; i<n; i++) {
			num[i]=Double.parseDouble(br.readLine());
		}
		for(int i=0; i<arr.length; i++) {
			if('A'<=arr[i]&& arr[i]<='Z') {
				st.add(num[arr[i]-'A']);
			} else if(arr[i]=='+'){
				st.add(st.pop()+st.pop());
			} else if(arr[i]=='-'){
				double a = st.pop();
				double b = st.pop();
				st.add(b-a);
			} else if(arr[i]=='/'){
				double a = st.pop();
				double b = st.pop();
				st.add(b/a);
			} else if(arr[i]=='*'){
				st.add(st.pop()*st.pop());
			} 
		}
		System.out.printf("%.2f",st.pop());
	}
}
