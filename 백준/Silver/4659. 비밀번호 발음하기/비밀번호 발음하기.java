import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!s.equals("end")){
            boolean flag = true;
            String s2 = s.replaceAll("[a,e,i,o,u]","");
            // 조건 1 : a,e,i,o,u 중 하나를 반드시 포함
            int cnt = s.length() - s2.length();
            if(cnt==0) flag = false;
            // 조건 2 : 모음이 3개이거나 자음이 3개 연속으로 오면 안됨
            int n = 0; // 모음 연속
            int m = 0; // 자음 연속
            String[] tmp = s.split("");
            for(int i=0; i<tmp.length; i++){
                if(tmp[i].replaceAll("[a,e,i,o,u]","").equals("")){
                    if(m>0) m = 0;
                    n++;
                } else {
                    if(n>0) n = 0;
                    m++;
                }
                if(n>2 || m>2) flag = false;

                if(n==2|| m==2){
                    if(tmp[i-1].equals(tmp[i]) && !tmp[i].equals("e") && !tmp[i].equals("o"))
                        flag = false;
                }
            }
            System.out.println("<"+s+"> is "+(flag?"":"not ")+"acceptable.");
            s = br.readLine();
        }
     }
}


