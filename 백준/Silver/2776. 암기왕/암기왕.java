import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map.put(Integer.parseInt(st.nextToken()), 1);
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                sb.append(map.containsKey(Integer.parseInt(st.nextToken()))?1:0).append('\n');
            }
            System.out.print(sb);
        }
    }
}
