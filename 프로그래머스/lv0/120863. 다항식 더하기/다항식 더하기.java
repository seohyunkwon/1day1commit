class Solution {
    public String solution(String polynomial) {
        int n = 0;
        int m = 0;
        String[] arr = polynomial.split(" ");
        for(String s : arr){
            if(s.contains("+")) continue;
            if (s.contains("x")){
                String tmp = s.replaceAll("x", "");
                n+=Integer.parseInt(tmp.equals("")?"1":tmp);
            } else {
                m+= Integer.parseInt(s);
            }
        }
        return m!=0?(n==0?m+"":(n==1?("x + "+m):(n+"x + "+m))):(n==0?"0":(n==1?"x":n+"x"));
    }
}