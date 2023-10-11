class Solution {
    public boolean solution(String s) {
        return s.length()!=4&&s.length()!=6?false:s.length()-s.toLowerCase().replaceAll("[a-z]", "").length()!=0?false:true;
    }
}