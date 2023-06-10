import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> dancing = new HashSet<>();
        boolean flag = false;
        int cnt = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(); String b = st.nextToken();
            if(a.equals("ChongChong") || b.equals("ChongChong")) {
                flag = true;
                dancing.add(a); dancing.add(b);
                cnt = 2;
            } else if(flag){
                int tmp = (dancing.contains(a)?1:0)+(dancing.contains(b)?1:0);
                if(tmp>0){
                    cnt+=2-tmp;
                    dancing.add(a); dancing.add(b);
                }
            }
        }
        System.out.println(dancing.size());
    }
}