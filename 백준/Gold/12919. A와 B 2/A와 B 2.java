import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        addString(S, T);

        System.out.println(0);
    }

    private static void addString(String S, String T) {
        if(S.length() >= T.length()) {
            if(S.equals(T)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        if(T.charAt(T.length() - 1) == 'A') {
            addString(S, T.substring(0, T.length() - 1));
        }

        if(T.charAt(0) == 'B') {
            addString(S, new StringBuilder(T).reverse().substring(0, T.length() - 1));
        }

    }
}
