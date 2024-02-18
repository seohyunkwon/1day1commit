import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while(!(str = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(str);
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());
            double c = Integer.parseInt(st.nextToken());
            // 제일 긴 변이 나머지 두 변을 합친 길이보다 길 때 Impossible
            String target = a == -1 ? "a" : b == -1 ? "b" : "c";
            double result = 0;
            if(target.equals("a")) {
                if(Math.pow(c, 2) - Math.pow(b, 2) <= 0) {
                    sb.append("Triangle #"+(tc++)+"\nImpossible.\n\n");
                    continue;
                }
                a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
                result = a;
            }
            if(target.equals("b")) {
                if(Math.pow(c, 2) - Math.pow(a, 2) <= 0) {
                    sb.append("Triangle #"+(tc++)+"\nImpossible.\n\n");
                    continue;
                }
                b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
                result = b;
            }
            if(target.equals("c")) {
                c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                result = c;
            }

            sb.append("Triangle #"+(tc++)+"\n"+String.format("%s = %.3f\n\n", target, result));
        }
        System.out.println(sb.toString().trim());
    }
}