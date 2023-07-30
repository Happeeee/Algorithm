import java.util.*;
public class Main {    
    private static List<Integer>[] adj = new ArrayList[50];
    private static boolean[] visited = new boolean[50];
    private static int root, n, d;

    private static int dfs(int here) {
        int leafCount = 0;
        int childCount = 0; // 자식을 지운게 아니라 안가는 것이므로 자식 개수 직접 체크

        for(int there : adj[here]) {
            if(there == d) continue; // 지운 노드라면 진행x, for문 이후에 자식 노드 개수를 알 수 있음
            leafCount += dfs(there);
            childCount++;
        }

        if(childCount == 0) return 1; // 자식 노드가 없으면 리프노드
        else return leafCount; // 있다면 자식 노드들로 부터 올라온 리프노드 수 반환
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 50; i++)
            adj[i] = new ArrayList<>();

        n = sc.nextInt();

        for(int child = 0; child < n; child++) {
            int parent = sc.nextInt();
            if(parent == -1) root = child;
            else adj[parent].add(child);
        }

        d = sc.nextInt();

        if(d == root) {
            System.out.println(0); return; // 루트를 지우는 경우
        }

        System.out.println(dfs(root));
    }
}
