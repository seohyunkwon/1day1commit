import java.util.*;
import java.io.*;

class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<Student>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				if(s1.kor!=s2.kor) return s2.kor-s1.kor;
				else {
					if(s1.eng!=s2.eng) return s1.eng-s2.eng;
					else {
						if(s1.math!=s2.math) {
							return s2.math-s1.math;
						} else return s1.name.compareTo(s2.name);
					}
				}
			}
		});
		for(Student s : list) {
			sb.append(s.name).append('\n');
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}

class Student{
	String name; int kor,eng,math;
	Student(String name, int kor, int eng, int math){
		this.name=name; this.kor=kor; this.eng=eng; this.math=math;
	}
}