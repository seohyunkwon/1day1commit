import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        while(pq.size() > 1) {
            int tmp = pq.poll()+pq.poll();
            pq.offer(tmp);
            sum+= tmp;
        }

        System.out.println(sum);

    }
}
