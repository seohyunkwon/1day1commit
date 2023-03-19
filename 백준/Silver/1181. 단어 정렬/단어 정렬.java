import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Word> set = new HashSet<Word>();
		for(int i=0; i<n; i++) {
			set.add(new Word(br.readLine()));
		}
		ArrayList<Word> list = new ArrayList<Word>(set);
		
		Collections.sort(list, new Comparator<Word>() {
			public int compare(Word w1, Word w2) {
				if(w1.length>w2.length) return 1;
				else if(w1.length<w2.length) return -1;
				else {
					return w1.s.compareTo(w2.s);
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for(Word w:list) {
			sb.append(w).append('\n');
		}
		System.out.println(sb);

	}
}

class Word {
	String s; int length;
	Word(String s) {
		this.s=s; this.length=s.length();
	}
	public String toString() {
		return s;
	}
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || getClass()!=o.getClass()) return false;
		Word w = (Word)o;
		return Objects.equals(s, w.s);
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(s);
	}
}