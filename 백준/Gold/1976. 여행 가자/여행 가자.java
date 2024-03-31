import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = i;
        }
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    int pa = find(i);
                    int pb = find(j);
                    union(pa, pb);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            set.add(find(Integer.parseInt(st.nextToken())-1));
        }

        System.out.println(set.size() == 1 ? "YES" : "NO");

    }

    static int find(int x) {
        if(p[x] != x) return p[x] = find(p[x]);
        return p[x];
    }

    static void union(int pa, int pb) {
        p[pb] = pa;
    }
}
