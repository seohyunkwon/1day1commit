import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i, i+2);
            if(tmp.replaceAll("[^a-z]","").length()!=tmp.length()) continue;
            list1.add(tmp.trim());
        }
        for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i, i+2);
            if(tmp.replaceAll("[^a-z]","").length()!=tmp.length()) continue;
            list2.add(tmp.trim());
        }
        int size1 = list1.size();
        int size2 = list2.size();
        if(size1==size2 && size1==0) return 65536;
        for(String tmp : list2){
            list1.remove(tmp);
        }
        int n = size1-list1.size();
        double total = size1+size2-n;
        return (int)(n/total*65536);
    }
}