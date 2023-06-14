import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i:queue1){
            q1.add(i);
        }
        for(int i:queue2){
            q2.add(i);
        }
        int cnt = 0;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long n = (sum1+sum2)/2;
        while(sum1 !=n || sum2!=n){
            if(sum1>n){
                int tmp = q1.poll();
                q2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
                answer++;
            }
            if(sum2>n){
                int tmp = q2.poll();
                q1.add(tmp);
                sum2 -= tmp;
                sum1 += tmp;
                answer++;
            }
            cnt++;
            if(cnt>10000000) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}