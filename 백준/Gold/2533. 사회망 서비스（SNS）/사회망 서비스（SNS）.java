import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static List<List<Integer>> adjLst = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 0번 index는 사용하지 않음
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            adjLst.add(new ArrayList<>());
        }
        dp = new int[N+1][2];

        int u, v;
        // 간선은 N-1개 들어옴
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adjLst.get(u).add(v);
            adjLst.get(v).add(u);
        }

        // 임의의 root에서 탐색 시작
        dfs(1);

        System.out.println(Math.min(dp[1][1], dp[1][0]));
    }

    public static void dfs(int u) {
        visited[u] = true;
        // 자신이 얼리어답터인 경우. 자기자신을 일단 더하고 시작해야함
        dp[u][1] = 1;
        for (int i = 0; i < adjLst.get(u).size(); i++) {
            int adj = adjLst.get(u).get(i);
            if (!visited[adj]) {
                dfs(adj);
                // 자신이 얼리어답터가 아니라면 자식들 모두 얼리어답터여야 함
                dp[u][0] += dp[adj][1];
                // 자신이 얼리어답터라면, 자식은 얼리어답터 여부와 무관함
                dp[u][1] += Math.min(dp[adj][0], dp[adj][1]);
            }
        }
    }
}