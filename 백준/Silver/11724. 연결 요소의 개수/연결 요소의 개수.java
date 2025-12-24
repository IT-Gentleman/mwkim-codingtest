
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            sc.nextLine();
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
            System.out.println(count);
    }

    static void bfs(int startIdx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startIdx);
        visited[startIdx] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}