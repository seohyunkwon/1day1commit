import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static String[] result;
    static StringBuffer sb;
    static int l,c;
    static boolean[] visited;
    static String[] arr;
    static int prev = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).sorted().toArray(String[]::new);
        sb = new StringBuffer();
        visited = new boolean[c];
        result = new String[l];
        backtracking(0);
        System.out.println(sb);

    }

    public static void backtracking(int depth){
        if(depth>=l){
            long x = Arrays.stream(result).filter(s->s.matches("[a,e,i,o,u]")).count();
            long y = Arrays.stream(result)
                    .filter(s -> !s.matches(".*[aeiou].*"))
                    .count();
            if(x>=1 && y>=2)
            sb.append(Arrays.stream(result).collect(Collectors.joining())+"\n");
            return;
        }
        for(int i=depth; i<c; i++){
            if(!visited[i] && prev<i){
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth+1);
                visited[i] = false;
                prev = i;
            }
        }
    }
}
