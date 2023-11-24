import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public int solution(String word) {
        String[] arr = {"A", "E", "I", "O", "U"};
        dfs("", arr, 0);
        return list.indexOf(word)+1;
    }
    
    private void dfs(String str, String[] arr, int depth){
        if(depth == 5 ) return;
        for(int i=0; i<arr.length; i++){
            list.add(str+arr[i]);
            dfs(str+arr[i], arr, depth+1);
        }
    }
}