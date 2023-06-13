import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:topping){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<topping.length; i++){
            set.add(topping[i]);
            if(map.getOrDefault(topping[i],0)-1==0)  {map.remove(topping[i]);}
            if(map.keySet().contains(topping[i])) {map.put(topping[i], map.get(topping[i])-1);}
            if(map.keySet().size()==set.size()) answer++;
            
        }
        return answer;
    }
}