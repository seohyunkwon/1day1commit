import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n,k));

    }

    public static int bfs(int n, int k){
        if(k==0) return n;
        boolean[] visited = new boolean[100002];
        int minstep = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int num = tmp[0];
            int step = tmp[1];
            if(num==k) {
                minstep = Math.min(step, minstep);
                continue;
            }
            if(num*2<=100001 && num !=0 && step+1<minstep) {
                if(!visited[num*2]){
                    visited[num*2] =true;
                    queue.add(new int[]{ num*2,step+1});
                }
            }
            if(num+1<=100001 && step+1<minstep) {
                if(!visited[num+1]) {
                    visited[num+1] = true;
                    queue.add(new int[]{ num+1,step+1});
                }
            }
            if(num-1>=0 && step+1<minstep) {
                if(!visited[num-1]) {
                    visited[num-1] = true;
                    queue.add(new int[]{num-1,step+1});
                }
            }
        }
        return minstep;
    }
}