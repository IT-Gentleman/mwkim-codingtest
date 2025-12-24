import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> adjLst;
    static int[] indegree;
    static int[] semester;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        semester = new int[N + 1];
        adjLst = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // idx 0은 사용하지 않음
            adjLst.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjLst.get(a).add(b);
            indegree[b]++;
        }

        // 큐 초기화
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                // indegree 없는것들은 1학기부터 학습 가능
                semester[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int adj : adjLst.get(cur)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    semester[adj] = semester[cur]+1;
                    q.add(adj);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }

    }
}