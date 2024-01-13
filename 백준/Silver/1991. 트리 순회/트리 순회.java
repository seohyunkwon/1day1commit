import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new Node((char)(i+'A')+""));
        }
        for(int i=0; i<N; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(m -> m.charAt(0)-'A')
                    .toArray();
            if(tmp[1] > -1)
                graph.get(tmp[0]).left = graph.get(tmp[1]);
            if(tmp[2] > -1)
                graph.get(tmp[0]).right = graph.get(tmp[2]);
        }

        preOrder(graph.get(0));
        System.out.println();
        inOrder(graph.get(0));
        System.out.println();
        postOrder(graph.get(0));
    }


    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value);
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value);
    }
}
