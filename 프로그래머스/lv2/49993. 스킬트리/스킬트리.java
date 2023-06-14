import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop:
        for(String s : skill_trees){

            Queue<Character> queue = new LinkedList<>();
            for(String a:skill.split("")){ queue.add(a.charAt(0)); }

            int idx = 0;
            while(idx<s.length()){
                if(queue.isEmpty()) {
                    break;
                }

                char c = queue.peek();

                if(s.charAt(idx)==c){
                    queue.poll();
                } else if (queue.contains(s.charAt(idx))){
                    continue loop;
                }
                idx++;

            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        int n = new Solution().solution("CBD", new String[]{"CAD"});
        System.out.println(n);

    }
}