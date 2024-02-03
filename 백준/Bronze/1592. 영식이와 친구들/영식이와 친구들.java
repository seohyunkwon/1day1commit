import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] people = new int[N];

        people[0] = 1;
        int idx = 0;
        int count = 0;
        while(true){
            if(people[idx]==M) break;
            count++;
            if(people[idx]%2==1) {
                idx = (idx+L)%N;
            } else {
                idx = (idx-L+N)%N;
            }
            people[idx]++;
        }
        System.out.println(count);
    }
}