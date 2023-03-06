
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[5];
        int total = 0;
        for(int i=0; i<5; i++) {
        	list[i] = Integer.parseInt(br.readLine());
        	total+=list[i];
        }
        Arrays.sort(list);
        System.out.println(total/5);
        System.out.println(list[2]);
    
    
    }
}