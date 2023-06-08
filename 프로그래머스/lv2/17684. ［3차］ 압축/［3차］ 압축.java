import java.util.*;
class Solution {
     public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1; i<27; i++){
            map.put((char)(i+64)+"",i);
        }
        if(msg.length()==1) return new int[]{map.get(msg)};

        StringBuilder tmp = new StringBuilder();
        String[] arr = msg.split("");
        int lastidx = 0;
        for(int i=0; i<arr.length; i++){
            tmp.setLength(0);
            if(i<arr.length-1){
                tmp.append(arr[i]);
                int idx = i+1;
                while(idx<arr.length){
                    tmp.append(arr[idx]);
                    if(!map.keySet().contains(tmp.toString())){
                        list.add(map.get(tmp.toString().substring(0, tmp.toString().length()-1)));
                        map.put(tmp.toString(), Collections.max(map.values())+1);
                        i+=tmp.length()-2;
                        lastidx = i;
                        break;
                    }
                    idx++;
                }
            }
        }
        tmp = new StringBuilder();
        for(int i=lastidx+1; i< arr.length; i++){
            tmp.append(arr[i]);
        }
        list.add(map.get(tmp.toString()));
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}