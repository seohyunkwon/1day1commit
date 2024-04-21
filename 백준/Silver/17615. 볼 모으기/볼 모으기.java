import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] balls;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = br.readLine().toCharArray();
        // 왼쪽으로
        // red
        result = Math.min(getCount('R', 'R', getEndPoint('R', 'R')), result);
        // blue
        result = Math.min(getCount('B', 'R', getEndPoint('B', 'R')), result);
        // 오른쪽으로
        // red
        result = Math.min(getCount('R', 'L', getEndPoint('R', 'L')), result);
        // blue
        result = Math.min(getCount('B', 'L', getEndPoint('B', 'L')), result);

        System.out.println(result);


    }

    static int getEndPoint(char color, char dir){
        if(dir == 'L') {
            int end = 0;
            for( ; end < N; end++) {
                if(balls[end] != color) break;
            }
            return end;
        }
        int end = N - 1;
        for( ; end>=0; end--) {
            if(balls[end] != color) break;
        }
        return end;
    }

    static int getCount(char color, char dir, int end) {
        int count = 0;
        if(dir == 'L') {
            for(int i = N-1; i >= end; i--) {
                if(balls[i] == color) count++;
            }
            return count;
        }
        for(int i = 0; i <= end; i++) {
            if(balls[i] == color) count++;
        }
        return count;
    }
}
