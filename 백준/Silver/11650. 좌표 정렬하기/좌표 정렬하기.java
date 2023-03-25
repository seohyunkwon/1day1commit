import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, (p1, p2)->p1.x!=p2.x?p1.x-p2.x:p1.y-p2.y); 
		for(Point a:list) {
			System.out.println(a);
		}
	}
}

class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return x+ " "+y;
	}
}