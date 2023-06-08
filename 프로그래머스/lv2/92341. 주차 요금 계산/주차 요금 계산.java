import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        for(String s:records){
            String[] arr = s.split(" ");
            if(arr[2].equals("IN")){
                map.put(arr[1],arr[0]);
            } else {
                String in = map.get(arr[1]);
                String out = arr[0];
                int time = ((Integer.parseInt(out.substring(0,2))-Integer.parseInt(in.substring(0,2)))*60)+Integer.parseInt(out.substring(3))-Integer.parseInt(in.substring(3));
                result.put(arr[1], result.getOrDefault(arr[1],0)+time);
                map.remove(arr[1]);
            }
        }
        if(map.keySet().size()>0){
            for(String s:map.keySet()){
                String in = map.get(s);
                int time = (23-Integer.parseInt(in.substring(0,2)))*60+60-Integer.parseInt(in.substring(3))-1;
                result.put(s, result.getOrDefault(s, 0)+time);
            }
        }
        int[] answer = new int[result.size()];
        int idx = 0;
        Set<String> set = result.keySet();
        for(String s:set){
            int total = fees[1];
            int time = result.get(s)-fees[0];
            if(time>0){
                total+=(int)Math.ceil(time/(double)fees[2])*fees[3];
            }
            answer[idx++]=total;
        }
        return answer;
    }
}