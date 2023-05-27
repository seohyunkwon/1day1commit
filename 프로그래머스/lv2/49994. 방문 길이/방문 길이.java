import java.util.*;
class Solution {
    public int solution(String dirs) {
        int cnt = 0;
        int x = 0; int y = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            String s = "";
            String s2 = "";
            switch(c){
                case 'U':
                    s = x+""+(y++)+""+x+""+y;
                    s2 = x+""+y+x+(y-1);
                    break;
                case 'D':
                    s = x+""+(y--)+""+x+""+y;
                    s2 = x+""+y+x+(y+1);
                    break;
                case 'R':
                    s = (x++)+""+y+""+x+""+y;
                    s2 = x+""+y+(x-1)+y;
                    break;
                case 'L':
                    s = (x--)+""+y+""+x+""+y;
                    s2 = x+""+y+(x+1)+y;
                    break;
            }
            if(x>5 || y>5 || x<-5 || y<-5) {
                x = x>5?5:x;
                x = x<-5?-5:x;
                y = y>5?5:y;
                y = y<-5?-5:y;
                continue;
            }
            if(!list.contains(s) || !list.contains(s2)) {
                list.add(s); list.add(s2); cnt++;
            }
        }
        return cnt;
    }
}