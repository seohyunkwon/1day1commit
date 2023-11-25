import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> stack = new Stack<>();
        int total = 0;
        for (String s : str.split("")) {
            if (s.equals("(") || s.equals("[")) stack.push(s);
            if (s.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(") && stack.peek().replaceAll("[0-9]", "").length()!=0) {
                    System.out.println(0);
                    return;
                }
                int sum = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    if(stack.peek().equals("[")){
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(stack.pop());
                }
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(sum!=0) stack.add(sum*2+"");
                else stack.add("2");
            }
            if (s.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[") && stack.peek().replaceAll("[0-9]", "").length()!=0) {
                    System.out.println(0);
                    return;
                }
                int sum = 0;
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    if(stack.peek().equals("(")){
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(stack.pop());
                }
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(sum!=0) stack.add(sum*3+"");
                else stack.add("3");

            }
        }
        long count = stack.stream().filter(s -> s.replaceAll("[0-9]", "").length()!=0).count();
        if(count>0) System.out.println(0);
        else System.out.println(stack.stream().mapToInt(Integer::parseInt).sum());
    }
}
