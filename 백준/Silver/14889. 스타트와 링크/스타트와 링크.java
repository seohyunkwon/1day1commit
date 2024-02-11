import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    private static int min, N;
    private static int[][] link;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        link = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            link[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        backtracking(0, 0);

        System.out.println(min);

    }

    private static void backtracking(int num, int depth){
        if(depth == N/2) {
            getSum();
            return;
        }
        for(int i = num; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void getSum(){
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    sum1 += (link[i][j] + link[j][i]);
                }
                if(!visited[i] && !visited[j]) {
                    sum2 += (link[i][j] + link[j][i]);
                }
            }
        }
        min = Math.min(min, Math.abs(sum1-sum2));
    }
}