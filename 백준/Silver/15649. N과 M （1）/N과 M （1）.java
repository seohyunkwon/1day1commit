import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] selected;
    static boolean[] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        visited = new boolean[n+1];
        backtrack(0);
        System.out.println(sb);
    }

    public static void backtrack(int depth){
        if(depth==m){
            for(int k : selected){
                sb.append(k).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                selected[depth] = i;
                visited[i] = true;
                backtrack(depth+1);
                visited[i] = false;
            }
        }
    }
}
