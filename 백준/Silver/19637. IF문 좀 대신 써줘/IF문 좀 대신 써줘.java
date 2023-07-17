import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Long> list;
    static HashMap<Long, String> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            long num = Long.parseLong(st.nextToken());
            if(map.keySet().contains(new Long(num))) continue;
            map.put(num, s);
        }
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int i=0; i<m; i++) {
            int start = 0;
            int end = list.size()-1;
            int t = (start+end)/2;
            int prev = t;
            long num = Long.parseLong(br.readLine());
            if(map.containsKey(new Long(num))){
                sb.append(map.get(num)+"\n");
                continue;
            }
            sb.append(binarySearch(num)+"\n");
        }
        System.out.println(sb);

    }

    public static String binarySearch(long num){
        int start = 0; int end = list.size()-1; int t = 0;
        while(start<=end) {
            t = (start+end)/2;
            if(list.get(t)<num) {
                start = t+1;
            } else if(list.get(t)>num){
                end = t-1;
            }
        }
        return map.get(list.get(end+1));
    }
}
