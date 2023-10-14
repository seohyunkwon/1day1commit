import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        String[] arr = new String[n];
        for(int i:reserve){
            arr[i-1] = "reserve";
        }
        for(int i:lost){
            arr[i-1] = arr[i-1]==null?"lost":null;
        }
        Stack<String> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==null) stack.add("none");
            else if(stack.isEmpty()){
                stack.add(arr[i]);
            } else if(arr[i].equals("reserve")){
                if(stack.peek().equals("lost")) {
                    stack.pop(); stack.add("none");
                } else stack.add("reserve");
            } else if(arr[i].equals("lost")) {
                if(stack.peek().equals("reserve")){
                    stack.pop(); stack.add("none");
                } else stack.add("lost");
            }
        }
            
        
        
        
        while(!stack.isEmpty()){
            if(stack.pop().equals("lost")) answer--;
        }
        
        return answer;
    }
}