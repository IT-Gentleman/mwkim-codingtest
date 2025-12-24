import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int[] head, to, weight, next;
    static int idx = 0;
    static int maxLen = 0;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        // 초기화
        head = new int[V + 1];
        Arrays.fill(head, -1);
        to = new int[2 * V];
        weight = new int[2 * V];
        next = new int[2 * V];
        visited = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            String[] parts = br.readLine().split(" ");
            int node = Integer.parseInt(parts[0]);
            for (int j = 1; j < parts.length - 1; j += 2) {
                int v = Integer.parseInt(parts[j]);
                int w = Integer.parseInt(parts[j + 1]);
                addEdge(node, v, w);
            }
        }

        dfs(1);
        System.out.println(maxLen);
    }

    static void addEdge(int u, int v, int w) {
        to[idx] = v;
        weight[idx] = w;
        next[idx] = head[u];
        head[u] = idx++;
    }

    static int dfs(int node) {
        int firstMax = 0, secondMax = 0;
        visited[node] = 1;

        for (int e = head[node]; e != -1; e = next[e]) {
            int v = to[e], w = weight[e];
            if (visited[v] == 0) {
                int pathLen = dfs(v) + w;
                if (pathLen > firstMax) {
                    secondMax = firstMax;
                    firstMax = pathLen;
                } else if (pathLen > secondMax) {
                    secondMax = pathLen;
                }
            }
        }

        maxLen = Math.max(maxLen, firstMax + secondMax);
        return firstMax;
    }
}