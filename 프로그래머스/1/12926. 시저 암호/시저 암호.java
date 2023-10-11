import java.util.*;
class Solution {
    public String solution(String s, int n) {
        LinkedList<Character> deque = new LinkedList<>();
        for(char c = 'a'; c<='z'; c++){
            deque.add(c);
        }
        for(int i=0; i<n; i++){
            deque.add(deque.poll());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' ') sb.append(' ');
            else if('a'<=c && c<='z'){
                sb.append(deque.get((int)(c-'a')));
            } else {
                sb.append((char)(deque.get((int)(c-'A'))-32));
            }
        }
        return sb.toString();
    }
}