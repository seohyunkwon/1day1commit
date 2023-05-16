import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prime = {2,3,5,7};
        if(n==1){
            Arrays.stream(prime).forEach(System.out::println);
            return;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : prime){
            stack.add(i);
        }

        while(!stack.isEmpty()){
            int m = stack.pop();
            for(int i=0; i<10; i++){
                int tmp = Integer.parseInt(m+""+i);
                if(isPrime(tmp)){
                    if(String.valueOf(tmp).length()==n) {
                        list.add(tmp);
                    } else stack.push(tmp);
                }
            }
        }
        list.stream().sorted().forEach(System.out::println);
    }

    public static boolean isPrime(int n){
        boolean flag = true;
        int root = (int)Math.sqrt(n);
        for(int i=2; i<=root; i++){
            if(n%i==0) flag=false;
        }
        return flag;
    }

}