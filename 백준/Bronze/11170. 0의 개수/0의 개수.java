import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<n; i++){
            int cnt = 0;
            Point p = arr[i];
            for(int j=p.x; j<=p.y; j++){
                String s = String.valueOf(j);
                if(s.contains("0")) {
                    cnt+=s.length()-s.replaceAll("0", "").length();
                }
            }
            System.out.println(cnt);
        }
    }
}

class Point{
    int x,y;
    Point(int x, int y){
        this.x=x; this.y=y;
    }
}