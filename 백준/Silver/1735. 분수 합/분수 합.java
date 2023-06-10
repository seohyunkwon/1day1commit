import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = a*d+c*b;
        int m = b*d;
        int gcd = getGCD(Math.min(n,m), Math.max(n,m));
        System.out.println(n/gcd+" "+m/gcd);
    }

    public static int getGCD(int min, int max){
        if(max==0) return min;
        return getGCD(max, min%max);
    }

}