import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> colorMap = new HashMap<>();
        HashMap<Integer,Integer> numberMap = new HashMap<>();

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            colorMap.put(color, colorMap.getOrDefault(color, 0)+1);
            int number = Integer.parseInt(st.nextToken());
            numberMap.put(number, numberMap.getOrDefault(number, 0)+1);
        }
        int result = 0;
        if(colorMap.keySet().size()==1){
            int min = Collections.min(numberMap.keySet());
            int max = Collections.max(numberMap.keySet());
            if(max-min==4) result = 900+max;
            else result = 600+max;
        } else {
            int tmp = numberMap.keySet().size();
            int min = Collections.min(numberMap.values());
            int max = Collections.max(numberMap.values());
            if(tmp==2){
                if(max==4) {
                    for(int i: numberMap.keySet()){
                        if(numberMap.get(i)==4){
                            result= i+800;
                        }
                    }
                } else if(max==3 && min ==2){
                    for(int i: numberMap.keySet()){
                        if(numberMap.get(i)==3){
                            result+=i*10;
                        } else {
                            result+=i+700;
                        }
                    }
                }
            } else if(max==1 && Collections.max(numberMap.keySet())-Collections.min(numberMap.keySet())==4){
                 result=Collections.max(numberMap.keySet())+500;
            } else if(max==3 && min==1){
                for(int i:numberMap.keySet()){
                    if(numberMap.get(i)==3) result=i+400;
                }
            } else if(tmp==3 && max==2 && min==1){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i: numberMap.keySet()){
                    if(numberMap.get(i)==2) list.add(i);
                }
                result=Collections.max(list)*10+Collections.min(list)+300;
            } else if(max==2){
                for(int i:numberMap.keySet()) {
                    if(numberMap.get(i)==2) result=i+200;
                }
            } else {
                for(int i: numberMap.keySet()){
                    if(numberMap.get(i)==max) result=i+100;
                }
            }
        }
        System.out.println(result);

    }
}
