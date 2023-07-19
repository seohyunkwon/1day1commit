import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = (int)Arrays.stream(s.split("")).filter((b)->b.equals("a")).count();
        int start = 0;
        int min = Integer.MAX_VALUE;
        while(start<s.length()){
            int end = start+a;
            String tmp = "";
            if(end>=s.length()){
                end = end - s.length();
                tmp = s.substring(0, end)+" "+s.substring(start);
            } else {
                tmp = s.substring(start, end);
            }
            int count = (int)Arrays.stream(tmp.split("")).filter((b)->b.equals("b")).count();
            min = Math.min(count,min);
            start++;
        }
        System.out.println(min);
    }
}