import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        loop:
        for(int i=0; i<t; i++) {
            String p = sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            String[] arr = sc.nextLine().substring(1).replace("]", "").split(",");
            LinkedList<String> list = new LinkedList<>();
            for (String tmp : arr) {
                if(tmp.equals("")) continue;
                list.add(tmp);
            }

            ArrayList<String> list3 = new ArrayList<>();
            boolean flag = false;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    flag = !flag;
                }
                else if (p.charAt(j) == 'D' && flag) {
                    list3.add("last");
                } else {
                    list3.add("first");
                }
            }
            for (String tmp : list3) {
                if (list.isEmpty()) {
                    System.out.println("error");
                    continue loop;
                } else if (tmp.equals("last")) {
                    list.pollLast();
                } else if (tmp.equals("first")) {
                    list.pollFirst();
                }
            }
            StringBuilder tmp = new StringBuilder();
            while(!list.isEmpty()){
                if(flag == true){
                    tmp.append(list.pollLast()+",");
                } else {
                    tmp.append(list.pollFirst()+",");
                }
            }
            if(tmp.length()>0){
                System.out.println("["+tmp.substring(0, tmp.toString().length()-1)+"]");
            } else {
                System.out.println("[]");
            }

        }


    }
}
