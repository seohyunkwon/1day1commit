import java.util.*;
class Solution {
    public int solution(String before, String after) {
        ArrayList<Character> list = new ArrayList<Character>();
        for(char c:before.toCharArray()){
            list.add(c);
        }
        for(char c:after.toCharArray()){
            if(!list.contains(c)) return 0;
            else list.remove(new Character(c));
        }
        return 1;
    }
}