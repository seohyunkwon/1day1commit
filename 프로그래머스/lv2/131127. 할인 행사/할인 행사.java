import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i< want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i=0; i<discount.length-9; i++){
            HashMap<String, Integer> test = new HashMap<>();
            for(int j=i; j<i+10; j++){
                test.put(discount[j], test.getOrDefault(discount[j],0)+1);
            }
            boolean flag = true;
            for(String s: map.keySet()){
                if(!map.get(s).equals(test.get(s))) flag=false;
            }
            if(flag) answer++;
        }
        return answer;
    }
}