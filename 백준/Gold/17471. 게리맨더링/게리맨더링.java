import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static List<Integer>[] graph;
    private static int N;
    private static int[] people;
    private static boolean[] select;
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        select = new boolean[N];
        graph = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for(int j = 0; j < M; j++) {
                graph[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }

        backtracking(0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    private static void backtracking(int num) {
        if(num == N) {
            check();
            return;
        }
        select[num] = true;
        backtracking(num + 1);
        select[num] = false;
        backtracking(num + 1);
    }

    private static void check(){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = 0; i <N; i++) {
            if(select[i]) {
                list1.add(i);
                continue;
            }
            list2.add(i);
        }
        if(list1.size() == 0 || list2.size() == 0) return;
        if(bfs(list1) && bfs(list2)) {
            int count1 = 0;
            int count2 = 0;
            for(int i = 0; i < N; i++) {
                if(select[i]) {
                    count1 += people[i];
                    continue;
                }
                count2 += people[i];
            }
            result = Math.min(result, Math.abs(count1-count2));
        }
    }

    private static boolean bfs(List<Integer> list) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N];
        visit[list.get(0)] = true;
        queue.add(list.get(0));
        int cnt = 1;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int i = 0; i < graph[num].size(); i++) {
                int tmp = graph[num].get(i);
                if(list.contains(tmp) && !visit[tmp]) {
                    queue.add(tmp);
                    visit[tmp] = true;
                    cnt++;
                }
            }
        }

        if(cnt == list.size()) return true;
        return false;
    }
}
