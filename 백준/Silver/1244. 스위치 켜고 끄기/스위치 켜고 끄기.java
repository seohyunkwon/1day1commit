import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switchs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            if(gender == 1) {
                for(int i=x; i<switchs.length; i+=(x+1)) {
                    switchs[i] = switchs[i]==1?0:1;
                }
                continue;
            }
            switchs[x] = switchs[x]==1?0:1;
            int start = x-1;
            int end = x+1;
            while(0 <= start && end < switchs.length) {
                if(switchs[start] == switchs[end]) {
                    switchs[start] = switchs[start]==1?0:1;
                    switchs[end] = switchs[end]==1?0:1;
                    start--; end++;
                    continue;
                }
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<switchs.length; i++) {
            sb.append(switchs[i]+" ");
            if((i+1) % 20 == 0) sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}