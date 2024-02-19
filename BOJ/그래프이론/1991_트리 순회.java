import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void preorder(int from) {
        int left = adj[from].get(0);
        int right = adj[from].get(1);

        System.out.print((char)(from + 'A'));
        if(left != -1) preorder(left);
        if(right != -1) preorder(right);
    }

    public static void inorder(int from) {
        int left = adj[from].get(0);
        int right = adj[from].get(1);

        if(left != -1) inorder(left);
        System.out.print((char)(from + 'A'));
        if(right != -1) inorder(right);
    }

    public static void postorder(int from) {
        int left = adj[from].get(0);
        int right = adj[from].get(1);

        if(left != -1) postorder(left);
        if(right != -1) postorder(right);
        System.out.print((char)(from + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            char p = s.charAt(0);
            char l = s.charAt(2);
            char r = s.charAt(4);

            if(l == '.') adj[p - 'A'].add(-1);
            else adj[p - 'A'].add(l - 'A');

            if(r == '.') adj[p - 'A'].add(-1);
            else adj[p - 'A'].add(r - 'A');
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
}
