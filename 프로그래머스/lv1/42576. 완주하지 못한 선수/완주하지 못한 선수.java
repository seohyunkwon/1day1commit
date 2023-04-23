import java.util.*;
 class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:participant) {
        	map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s:completion) {
        	map.put(s, map.get(s)-1);
        }
        Iterator<String>it = map.keySet().iterator();
        while(it.hasNext()) {
        	String s = it.next();
        	if(map.get(s)>0) {
        		return s;
        	}
        }
        return "";
    }
 }