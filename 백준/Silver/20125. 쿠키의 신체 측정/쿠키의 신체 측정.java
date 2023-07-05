import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean isHead = false;
        boolean isWaist = false;
        int[] heart = new int[2];
        int[] cnt = new int[5];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            int m = s.length()-s.replaceAll("\\*","").length();
            if(m==1 && !isHead){
                isHead = true;
                heart[1] = s.indexOf("*");
                heart[0] = i+1;
            } else {
                if(isHead && i == heart[0]) {
                    String left = s.substring(0, heart[1]);
                    String right = s.substring(heart[1]+1);
                    cnt[0] = left.length()-left.replaceAll("\\*","").length();
                    cnt[1] = right.length()-right.replaceAll("\\*","").length();
                    isWaist = true;
                } else if(isWaist){
                    if(m==1) {
                        cnt[2] += 1;
                    } else {
                        isWaist= false;
                    }
                }

                if(!isWaist && cnt[2]>0){
                    String left = s.substring(0, heart[1]);
                    String right = s.substring(heart[1]+1);
                    cnt[3] += left.length()-left.replaceAll("\\*","").length();
                    cnt[4] += right.length()-right.replaceAll("\\*", "").length();
                }

            }
        }
        System.out.println((heart[0]+1)+" "+(heart[1]+1));
        System.out.println(cnt[0]+" "+cnt[1]+" "+cnt[2]+" "+cnt[3]+" "+cnt[4]);

     }
}


