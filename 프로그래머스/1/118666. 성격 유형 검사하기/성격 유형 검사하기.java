import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        KakaoTest kt = new KakaoTest();
        for(int i=0; i<survey.length; i++){
            kt.setScore(survey[i], choices[i]);
        }
        return kt.getResult();
    }
}

class KakaoTest{
    
    HashMap<String, Integer> score;
    String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
    public KakaoTest(){
        score = new HashMap<>();
        for(String s:types) {
            score.put(s, 0);
        }
    }
    public void setScore(String type, int choice){
        
        if(choice<4) {
            score.put(type.substring(0,1), 
                    (score.get(type.substring(0,1))+(choice!=2?(choice==1?3:1):2)));
        }
        if(choice>4){
            score.put(type.substring(1),
                   score.get(type.substring(1))+(choice-4));
        }
    }
    
    public String getResult(){
        StringBuilder sb = new StringBuilder();
        sb.append(score.get("R")<score.get("T")?"T":"R");
        sb.append(score.get("C")<score.get("F")?"F":"C");
        sb.append(score.get("J")<score.get("M")?"M":"J");
        sb.append(score.get("A")<score.get("N")?"N":"A");
        System.out.println(score);
        return sb.toString();
    }
}