import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i: Arrays.stream(X.split("")).mapToInt(Integer::parseInt).toArray()){
            map1.put(i, map1.getOrDefault(i,0)+1);
        } 
        for(int i: Arrays.stream(Y.split("")).mapToInt(Integer::parseInt).toArray()){
            map2.put(i, map2.getOrDefault(i,0)+1);
        }
        List<Integer> list1 = map1.keySet().stream().collect(Collectors.toList());
        list1.retainAll(map2.keySet().stream().collect(Collectors.toList()));
        if(list1.size()==0) return "-1";
        StringBuilder ans = new StringBuilder();
        for(int i: list1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList())){
            for(int j=0; j<Math.min(map1.get(i), map2.get(i)); j++){
                ans.append(i+"");
            }
        }
        if(ans.toString().replaceAll("0","").equals("")) return "0";
        return ans.toString();
    }
}