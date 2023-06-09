import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            map.put(s, i);
            map2.put(i,s);
        }
        for(int i=0; i<m; i++){
            String s = br.readLine();
            try {
                int tmp = Integer.parseInt(s);
                sb.append(map2.get(tmp)).append("\n");
            } catch (NumberFormatException e){
                sb.append(map.get(s)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
