import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(sc.nextInt() == 0) {
                hList.add(sc.nextInt());
                continue;
            }
            wList.add(sc.nextInt());
        }
        Collections.sort(wList);
        Collections.sort(hList);
        int maxW = 0;
        int idxW = 0;
        int maxH = 0;
        int idxH = 0;
        for(int i:wList){
            maxW = Math.max(i-idxW, maxW);
            idxW = i;
        }
        maxW = Math.max(w-idxW, maxW);
        for(int i:hList){
            maxH = Math.max(i-idxH, maxH);
            idxH = i;
        }
        maxH = Math.max(h-idxH, maxH);
        System.out.println(maxH*maxW);
        sc.close();
    }
}
