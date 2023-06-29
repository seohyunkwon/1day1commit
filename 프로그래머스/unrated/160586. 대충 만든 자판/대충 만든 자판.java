import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String tmp : keymap){
            for(int i=0; i<tmp.length(); i++){
                String s = tmp.charAt(i)+"";
                map.put(s, Math.min(map.getOrDefault(s, Integer.MAX_VALUE), i+1));
            }
        }
        int[] answer = new int[targets.length];
        loop:
        for(int i=0; i<targets.length; i++){
            int cnt = 0;
            String tmp = targets[i];
            for(int j=0; j<tmp.length(); j++){
                if(map.containsKey(tmp.charAt(j)+""))
                    cnt+= map.get(tmp.charAt(j)+"");
                else {
                    answer[i] = -1;
                    continue loop;
                }
            }
            answer[i] = cnt==0?-1:cnt;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }


}