
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];

        for(int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int pa = find(a);
            int pb = find(b);
            if(command == 0) {
                union(pa, pb);
            } else if(pa == pb){
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }

    static int find(int x) {
        if(p[x] != x) return p[x] = find(p[x]);
        return p[x];
    }

    static void union(int pa, int pb) {
        p[pb] = pa;
    }
}
