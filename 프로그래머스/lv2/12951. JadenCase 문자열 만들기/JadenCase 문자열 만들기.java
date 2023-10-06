class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            if(str.equals("")) {
                sb.append(" ");
                continue;
            }
            sb.append(str.substring(0,1).toUpperCase()+str.toLowerCase().substring(1)+((i==arr.length-1)?"":" "));
        }
        return sb.toString()+(s.charAt(s.length()-1)==' '?" ":"");
    }
}