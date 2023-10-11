class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<s.length(); i++){
            String tmp = s.substring(i, i+1);
            if(tmp.equals(" ")) {
                flag = false;
                sb.append(" ");
                continue;
            }
            sb.append(!flag?tmp.toUpperCase():tmp.toLowerCase());
            flag = !flag;
        }
        return sb.toString();
    }
}