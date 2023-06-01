import java.util.*;
class Solution {
    public int[] solution(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->a.length()-b.length());
        String[] arr = s.replaceAll("\\{","").split("\\}\\,");
        for(String a : arr){
            pq.offer(a.replaceAll("\\}",""));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            StringTokenizer st = new StringTokenizer(pq.poll(),",");
            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                if(!list.contains(tmp)){
                    list.add(tmp);
                }
            }
            
        }
        System.out.println(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
       

    }
}