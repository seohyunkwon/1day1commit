import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            String[] tmp = photo[i];
            int sum = 0;
            for(int j=0; j<tmp.length; j++){
                sum+= map.getOrDefault(tmp[j], 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}