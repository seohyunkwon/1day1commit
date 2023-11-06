import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> doc = new HashMap<>();
        int cnt = 1;
        for(char c = 'A'; c<='Z'; c++){
            doc.put(c+"", cnt++);
        }
        while(msg.length()!=0){
            int idx = 0;
            String str = "";
            for(String s:doc.keySet()){
                if(!msg.startsWith(s) || idx>doc.get(s)) continue;
                idx = doc.get(s);
                str = s;
            }
            result.add(idx);
            msg = msg.replaceFirst(str,"");
            if(msg.length()>0) doc.put(str+msg.charAt(0), cnt++);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}