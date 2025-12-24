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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjLst.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.print(cur+" ");

            for (int next : adjLst.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

    }
}