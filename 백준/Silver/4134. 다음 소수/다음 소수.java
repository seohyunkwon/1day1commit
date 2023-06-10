import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(long i=0; i<n; i++){
            long m = Long.parseLong(br.readLine());
            while(true){
                long tmp = m;
                if(isPrime(tmp)){
                    sb.append(tmp+"\n"); break;
                }
                for(long j=2; j<=Math.sqrt(tmp)+1; j++){
                    if(tmp%(j-1)==0) {
                        tmp++;
                        j=2;
                        continue;
                    }
                }
                sb.append((tmp<2?2:tmp)+"\n");
                break;
            }
        }
        System.out.println(sb);
    }
    public static boolean isPrime(long n){
        if(n==2) return true;
        for(long i=2; i<=Math.sqrt(n)+1; i++){
            if(n%i==0) return false;
        }
        return n<2?false:true;
    }
}