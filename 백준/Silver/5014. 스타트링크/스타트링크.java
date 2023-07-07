import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());   // 건물 높이
        int s = Integer.parseInt(st.nextToken());   // 현재 위치
        int g = Integer.parseInt(st.nextToken());   // 스타트링크 위치
        int u = Integer.parseInt(st.nextToken());   // 위
        int d = Integer.parseInt(st.nextToken());   // 아래
        if(s==g) {
            System.out.println(0);
            return;
        }
        int[] building = new int[f+1];
        boolean[] visited = new boolean[f+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(visited[tmp]) continue;
            if(tmp==g) break;
            visited[tmp] = true;
            int up = tmp+u;
            int down = tmp-d;
            if(up>0 && up<building.length){
                if(!visited[up]){
                    building[up] = building[tmp]+1;
                    queue.add(up);
                }
            }

            if(down>0 && down< building.length){
                if(!visited[down]){
                    building[down] = building[tmp]+1;
                    queue.add(down);
                }
            }


        }
        System.out.println(building[g]==0?"use the stairs":building[g]);

    }
}