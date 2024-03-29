import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt((st.nextToken()))));
		}
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.y>p2.y) return 1;
				else if(p1.y<p2.y) return -1;
				else {
					if(p1.x>p2.x) return 1;
					else return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for(Point p : list) {
			sb.append(p).append("\n");
		}
		System.out.println(sb);
	}
}

class Point {
	int x,y;
	Point(int x, int y) {
		this.x = x; this.y=y;
	}
	public String toString() {
		return x+" "+y;
	}
}