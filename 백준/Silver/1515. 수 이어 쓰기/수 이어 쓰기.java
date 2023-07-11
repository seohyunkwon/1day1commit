import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = 1;
        loop:
        while(true){
            String tmp = Integer.toString(num);
            while(tmp.length()>0 && s.length()>0){
                if(s.charAt(0)==tmp.charAt(0)){
                    s = s.substring(1);
                    tmp = tmp.substring(1);
                } else if(s.charAt(0)!=tmp.charAt(0)) {
                    tmp = tmp.substring(1);
                }
            }
            if(s.equals("")) break;
            num++;
        }
        System.out.println(num);
    }
}