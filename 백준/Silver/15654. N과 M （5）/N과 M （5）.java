import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuffer sb = new StringBuffer();
    static int l,c;
    static int[] selected;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        selected = new int[c];
        visited = new boolean[l+1];
        backtracking(0);
        System.out.println(sb);

    }
    public static void backtracking(int depth){
        if(depth==c) {
            for(int i:selected){
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i< arr.length; i++) {
            if (!visited[i]) {
                selected[depth] = arr[i];
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
