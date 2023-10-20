import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new LinkedList<>();
        for(String s : operations){
            int idx = -1;
            if(s.equals("D 1")){
                while(idx==-1 && !pq2.isEmpty()){
                    int tmp = pq2.poll();
                    idx = list.indexOf(tmp);
                }
                if(idx!=-1) list.remove(idx);
            } else if(s.equals("D -1")){
                while(!pq1.isEmpty()&&idx==-1){
                    int tmp = pq1.poll();
                    idx = list.indexOf(tmp);
                }
                if(idx!=-1) list.remove(idx);
            } else {
                int n = Integer.parseInt(s.split(" ")[1]);
                list.add(n);
                pq1.add(n);
                pq2.add(n);
            }
        }
        
        if(list.size()==0) return new int[]{0,0};
        Collections.sort(list);
        return new int[]{list.get(list.size()-1), list.get(0)};
    }
}