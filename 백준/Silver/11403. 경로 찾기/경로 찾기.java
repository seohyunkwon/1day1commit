import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    cost[i][j] = 1;
                }
            }
        }

        // 플로이드 워셜
        for (int i = 0; i < N; i++) {   // 경유지
            for (int j = 0; j < N; j++) {   // 출발지
                for (int k = 0; k < N; k++) {   // 목적지
                	if (cost[j][i] == 1 && cost[i][k] == 1) {	// 경로가 있으면 1로 초기화
                        cost[j][k] = 1;
                    }
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();

        for (int[] arr : cost) {
        	for(int i : arr) {
        		sb.append(i + " ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);

    }

}
