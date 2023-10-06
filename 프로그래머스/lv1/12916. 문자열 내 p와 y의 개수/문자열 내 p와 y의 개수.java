class Solution {
    boolean solution(String s) {
        int pcnt = s.length()-s.replaceAll("P","").replaceAll("p","").length();
        int ycnt = s.length()-s.replaceAll("Y","").replaceAll("y","").length();
        return pcnt==ycnt?true:false;
    }
}