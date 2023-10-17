import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("}");
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a.length-b.length);
        List<Integer> list = new ArrayList<>();
        for(String s2:arr){
            int[] tmp = Arrays.stream(s2.replaceAll("\\{","").split(","))
                    .filter(a->a.length()>0)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(tmp);
        }
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            for(int i:tmp){
                if(!list.contains(i)) list.add(i);
            }
        }
        int[] answer = new int[arr.length];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}