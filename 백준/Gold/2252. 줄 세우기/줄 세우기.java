import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> adjLst;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        adjLst = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // idx 0은 사용하지 않음
            adjLst.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            adjLst.get(a).add(b);
            indegree[b]++;
        }

        // 큐 초기화
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for (int adj : adjLst.get(cur)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }

    }
}