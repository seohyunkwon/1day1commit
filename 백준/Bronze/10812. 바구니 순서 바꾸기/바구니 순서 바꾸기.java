import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> baskets;

    static void rotate(int begin, int end, int mid) {
        int size = end - begin + 1;
        List<Integer> temp = new ArrayList<>(size);

        for (int i = mid; i <= end; i++) {
            temp.add(baskets.get(i));
        }

        for (int i = begin; i < mid; i++) {
            temp.add(baskets.get(i));
        }

        for (int i = 0; i < size; i++) {
            baskets.set(begin + i, temp.get(i));
        }
    }

    static void printBaskets() {
        for (int i = 0; i < N; i++) {
            System.out.print(baskets.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        baskets = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            baskets.add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int mid = Integer.parseInt(st.nextToken()) - 1;
            rotate(begin, end, mid);
        }

        printBaskets();
    }
}
