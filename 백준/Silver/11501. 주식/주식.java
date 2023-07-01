import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
           int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            while(st.hasMoreTokens()){
                int j = Integer.parseInt(st.nextToken());
                list.add(j);
            }
            long total = 0;
            int max = -1;
            while(list.size()>=2){
                int tmp = list.pollLast();
                max = max>tmp?max:tmp;
                if(list.peekLast()<max){
                    total+=max-list.peekLast();
                }
            }

            System.out.println(total);

        }
    }
}
