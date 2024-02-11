import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int N, S;
    private static int[] numbers;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);
        if(S == 0) count--;
        System.out.println(count);
    }

    private static void comb(int idx, int sum) {
        if(idx == N) {
            if(sum == S) count++;
            return;
        }
        comb(idx + 1, sum + numbers[idx]);
        comb(idx + 1, sum);
    }
}