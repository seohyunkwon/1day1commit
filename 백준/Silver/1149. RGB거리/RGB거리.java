import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] graph = new int[n][arr.length];
        for(int i=0; i<n; i++){
            int[] tmp;
            if(i==0) tmp = arr;
            else tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<tmp.length; j++){
                graph[i][j] = tmp[j];
            }
        }

        int[][] result = new int[graph.length][graph[0].length];
        for(int i=0; i<arr.length; i++){
            result[0][i] = arr[i];
        }
        for(int i=1; i<graph.length; i++){
            for(int j=0; j< result[0].length; j++){
                if(j==0) graph[i][j] = graph[i][j]+Math.min(graph[i-1][j+1], graph[i-1][j+2]);
                else if(j==graph[0].length-1) graph[i][j]=graph[i][j]+Math.min(graph[i-1][j-1], graph[i-1][j-2]);
                else graph[i][j] = graph[i][j]+Math.min(graph[i-1][j-1], graph[i-1][j+1]);
            }
        }

        System.out.println(Arrays.stream(graph[graph.length-1]).min().getAsInt());

    }
}
