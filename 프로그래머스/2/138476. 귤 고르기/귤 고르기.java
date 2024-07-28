import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        PriorityQueue<Obj> pq = new PriorityQueue<>();
        
        for(Integer num : map.keySet()) {
            pq.offer(new Obj(num, map.get(num)));
        }
        
        while(k > 0) {
            int tmp = pq.poll().cnt;
            answer++;
            if(tmp <= k) {
                k -= tmp;
                continue;
            }
            break;
        }
        
        return answer;
    }
    
    class Obj implements Comparable<Obj> {
        int num, cnt;
        
        Obj(int num, int cnt) {
            this.num = num; this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Obj obj) {
            return obj.cnt - this.cnt;
        }
    }
}