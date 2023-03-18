import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int happy = s.length()-(s.replace(":-)", "")).length();
		int sad = s.length()-(s.replace(":-(", "")).length();
		if(!s.contains(":-)")&&!s.contains(":-(")) {
			System.out.println("none"); return;
		}
		
		System.out.println(happy>sad?"happy":happy==sad?"unsure":"sad");
		
	
	}
}