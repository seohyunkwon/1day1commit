import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static StringBuilder sb;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        selected = new int[n];
        backtracking(0, 0);
        System.out.println(sb);

    }

    public static void backtracking(int depth, int j){
        if(depth>=m) {
            for(int i=0; i<depth; i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=j+1; i<=n; i++){
            selected[depth] = i;
            backtracking(depth+1, i);
        }
    }
}
