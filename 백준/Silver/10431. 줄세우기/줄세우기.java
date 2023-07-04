import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LinkedList<Integer> list = new LinkedList<>();
            long total = 0;
            for(int j=1; j< tmp.length; j++){
                list.add(tmp[j]);
                Collections.sort(list);
                int idx = list.indexOf(new Integer(tmp[j]));
                if(idx!=list.size()-1){
                    total+= list.size()-idx-1;
                }
            }
            sb.append(i+" "+total+"\n");
        }
        System.out.println(sb);
    }
}
