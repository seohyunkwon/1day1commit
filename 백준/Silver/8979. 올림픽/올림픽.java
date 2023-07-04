import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new int[]{idx, gold, silver, bronze});
        }
        Collections.sort(list, (a,b)->b[1]!=a[1]?b[1]-a[1]:(a[2]!=b[2]?b[2]-a[2]:b[3]-a[3]));
        int result = 0;
        int[] prev = {-1,-1,-1};
        for(int[] tmp:list){
            if(tmp[1]!=prev[0] || tmp[2]!=prev[1] || tmp[3]!=prev[2]){
                result++;
                prev[0] = tmp[1];
                prev[1] = tmp[2];
                prev[2] = tmp[3];
            }
            if(tmp[0]==k) {
                System.out.println(result); break;
            }
        }
    }
}
