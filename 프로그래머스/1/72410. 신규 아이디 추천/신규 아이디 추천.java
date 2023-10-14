class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z|^0-9|^\\-|^\\_|^\\.]","")
                       .replaceAll("\\^","");
        new_id = new_id.replaceAll("\\.{2,}",".");
        new_id = new_id.replaceAll("^\\.", "").replaceAll("\\.$","");
        new_id = new_id.length()==0?"a":new_id;
        new_id = new_id.length()>=16?
            new_id.substring(0, 15).replaceAll("\\.$",""):new_id;
        if(new_id.length()<3){
            while(new_id.length()<3){
                new_id = new_id+new_id.charAt(new_id.length()-1);
            }
        }
        
        
        return new_id;
    }
}

// 소문자, 숫자, - , _, .(처음, 끝, 연속x)