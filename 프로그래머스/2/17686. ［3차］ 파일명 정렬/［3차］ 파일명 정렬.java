import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            String number = "";
            int start = -1;
            int end = files[i].length();
            for(int j=0; j<files[i].length(); j++){
                char c = files[i].charAt(j);
                if('0' <= c && c<= '9') {
                    start = j;
                    break;
                }
            }
            if(start != -1) {
                for(int j=start; j<files[i].length(); j++){
                    char c = files[i].charAt(j);
                    if('0' > c ||  c > '9') {
                        end = j;
                        break;
                    }
                }
                number = files[i].substring(start, end);
            }
            String head = files[i];
            String tail = "";
            if(number.length()!=0){
                head = files[i].substring(0, files[i].indexOf(number));
            }
            if(head.length()+number.length()!=files[i].length())
                tail = files[i].substring(head.length()+number.length());
            File file = new File(head, number, tail, i);
            list.add(file);
        }
        return list.stream()
            .sorted()
            .map(file -> file.head+file.number+file.tail)
            .toArray(String[]::new);
    }
}

class File implements Comparable{
    String head;
    String number;
    String tail;
    int idx;
    File(String head, String number, String tail, int idx){
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.idx = idx;
    }
    
    private int getNumber(String number){
        if(number.equals("") || number.equals(" ") || number.equals(null)) return 0;
        return Integer.parseInt(number);
    }
    
    @Override
    public int compareTo(Object o){
        File f2 = (File)o;
        if(!this.head.toLowerCase().equals(f2.head.toLowerCase())){
            return this.head.compareToIgnoreCase(f2.head);
        }
        
        if(getNumber(this.number)!=getNumber(f2.number)){
            return getNumber(this.number)-getNumber(f2.number);
        }
        return this.idx-f2.idx;
    }
}