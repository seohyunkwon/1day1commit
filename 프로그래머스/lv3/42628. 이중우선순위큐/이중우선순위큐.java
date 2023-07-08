import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        for(String s:operations){
            StringTokenizer st = new StringTokenizer(s);
            String tmp = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if(tmp.equals("I")){
                q1.add(n); q2.add(n);
            } else if(n==-1){
                if(!q2.isEmpty()) {
                    int m = q1.poll();
                    q2.remove(new Integer(m));
                }
            } else {
                if(!q1.isEmpty()) {
                    int m = q2.poll();
                    q1.remove(new Integer(m));
                }
                
            }
        }
        int[] answer = new int[2];
        if(!q1.isEmpty()) answer[1] = q1.poll();
        if(!q2.isEmpty()) answer[0] = q2.poll();
        return answer;
    }
}