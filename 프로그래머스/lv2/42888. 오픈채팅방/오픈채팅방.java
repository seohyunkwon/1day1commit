import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String[]> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(String s:record){
            String[] arr = s.split(" ");
            if(arr[0].equals("Enter")){
                list.add(new String[]{arr[1],"Enter"});
                map.put(arr[1], arr[2]);
            } else if(arr[0].equals("Leave")){
                list.add(new String[]{arr[1],"Leave"});
            } else {
                map.put(arr[1], arr[2]);
            }
            
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            if(list.get(i)[1].equals("Enter")){
                answer[i] = map.get(list.get(i)[0])+"님이 들어왔습니다.";
            } else {
                answer[i] = map.get(list.get(i)[0])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}