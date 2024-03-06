
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] current1 = new int[N];
        int[] current2 = new int[N];
        int[] target = new int[N];
        String current_string = br.readLine();
        String target_string = br.readLine();

        for(int i = 0; i < N; i++) {
            current1[i] = current_string.charAt(i) - '0';
            current2[i] = current1[i];
            target[i] = target_string.charAt(i) - '0';
        }

        int count1 = 0;

        for(int i = 1; i < current1.length; i++) {
            if(current1[i-1] != target[i-1]) {
                count1++;
                current1[i-1] = current1[i-1]==1?0:1;
                current1[i] = current1[i]==1?0:1;
                if(i != current1.length -1) {
                    current1[i+1] = current1[i+1]==1?0:1;
                }
            }
        }

        current2[0] = current2[0] == 1 ? 0 : 1;
        current2[1] = current2[1] == 1 ? 0 : 1;

        int count2 = 1;

        for(int i = 1; i < current2.length; i++) {
            if(current2[i-1] != target[i-1]) {
                count2++;
                current2[i-1] = current2[i-1]==1?0:1;
                current2[i] = current2[i]==1?0:1;
                if(i != current2.length -1) {
                    current2[i+1] = current2[i+1]==1?0:1;
                }
            }
        }

        boolean flag1 = Arrays.equals(target, current1);
        boolean flag2= Arrays.equals(target, current2);

        if(!flag1 && !flag2) {
            System.out.println(-1);
            return;
        }

        if(!flag2) {
            System.out.println(count1);
            return;
        }

        if(!flag1) {
            System.out.println(count2);
            return;
        }

        System.out.println(Math.min(count1, count2));
    }
}