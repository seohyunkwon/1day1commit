import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> negative = new PriorityQueue<>();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        int zero = 0;
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp>0) positive.add(tmp);
            else if(tmp<0) negative.add(tmp);
            else zero++;
        }

        long total = 0;

        while(positive.size()>1){
            int tmp1 = positive.poll();
            int tmp2 = positive.poll();
            if(tmp1*tmp2>tmp1+tmp2){
                total += tmp1*tmp2;
            } else {
                total += tmp1+tmp2;
            }
        }
        while(!positive.isEmpty()){
            total += positive.poll();
        }
        while(negative.size()>1){
            total += negative.poll()*negative.poll();
        }
        while(zero>0 && !negative.isEmpty()){
            zero--;
            negative.poll();
        }

        while(!negative.isEmpty()){
            total += negative.poll();
        }
        System.out.println(total);
    }
}
