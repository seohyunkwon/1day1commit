import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Member> list = new ArrayList<Member>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(age,name,i));
		}
		Collections.sort(list);
		for(Member m : list) {
			System.out.println(m);
		}
		
	}
}

class Member implements Comparable<Member>{
	int age,num; String name;
	@Override
	public String toString() {
		return age+" "+name;
	}
	Member(int age,String name,int num){
		this.age=age;
		this.name=name;
		this.num=num;
	}
	@Override
	public int compareTo(Member m) {
		if(this.age==m.age) return this.num-m.num;
		else return this.age-m.age;
		}
}