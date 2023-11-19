import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> users = new HashMap<>();
        List<String[]> actions = new ArrayList<>();
        for(String s : record){
            StringTokenizer st = new StringTokenizer(s);
            String type = st.nextToken();
            String id = st.nextToken();
            if(type.equals("Enter")){
                String nickname = st.nextToken();
                actions.add(new String[]{id, "Enter"});
                users.put(id, nickname);
                continue;
            }
            if(type.equals("Leave")){
                actions.add(new String[]{id, "Leave"});
                continue;
            }
            if(type.equals("Change")){
                String nickname = st.nextToken();
                users.put(id, nickname);
                continue;
            }
        }
        return actions.stream()
            .map(action -> getMessage(action[0], action[1], users))
            .toArray(String[]::new);
    }
    
    private String getMessage(String id, String action, Map<String, String> users){
        if(action.equals("Enter")) {
            return users.get(id)+"님이 들어왔습니다.";
        }
        return users.get(id)+"님이 나갔습니다.";
    }
}