import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        List<Stack<Integer>> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            list.add(new Stack<>());
        }
        for(int i=board.length-1; i>=0; i--){
            int[] tmp = board[i];
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]!=0) list.get(j).add(board[i][j]);
            }
        }
        for(int i=0; i<moves.length; i++){
            Stack<Integer> st = list.get(moves[i]-1);
            if(st.isEmpty()) continue;
            int tmp = st.pop();
            if(stack.isEmpty() || (!stack.isEmpty()&&stack.peek()!=tmp)) {
                stack.add(tmp);
            } else {
                stack.pop(); answer+=2;
            }
        }
        return answer;
    }
}