import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int times = 1;
        int cnt = 0;
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(i%n==0) times++;
            if(set.contains(words[i]) || words[i].charAt(0)!=words[i-1].charAt(words[i-1].length()-1)){
                cnt = i%n+1;
                break;
            }
            set.add(words[i]);
            
        }
    
        return new int[]{cnt==0?0:cnt, cnt==0?0:times};
    }
}