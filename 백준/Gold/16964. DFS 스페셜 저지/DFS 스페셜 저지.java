import java.io.*;
import java.util.*;

/*
1. 한 점을 정해서, 탐색 시작
2. 탐색 과정에서 시작점으로 돌아오면 true
3. 시작점으로 돌아오는 경로가 없다면 다른 점 탐색 시작
 */

public class Main {

    static int N;
    static List<HashSet<Integer>> adjList;
    static int[] dfsResult;
    static int dfsIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();

        // 정점번호가 1부터 N까지이기에, 0부터 N까지 N+1개를 확보해두고, idx0은 미사용
        for (int i = 0; i <= N; i++) {
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        dfsResult = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dfsResult[i] = Integer.parseInt(st.nextToken());
        }
        if (dfsResult[0] != 1) {
            System.out.println(0);
            return;
        }
        dfs(1);
    }

    static void dfs(int treeIdx) {
        if (dfsIdx == dfsResult.length-1) { // 다 맞음
            System.out.println(1);
            System.exit(0);
        }
        // 비지 않았다면 더 깊이 탐색했을것임
        while (!adjList.get(treeIdx).isEmpty()) {
            // 정상적으로 탐색했다면 인접했을것임
            if (adjList.get(treeIdx).contains(dfsResult[dfsIdx+1])) {
                adjList.get(treeIdx).remove(dfsResult[dfsIdx+1]);
                adjList.get(dfsResult[dfsIdx+1]).remove(treeIdx);
                dfsIdx++;
                dfs(dfsResult[dfsIdx]);
            // 비지 않았는데 이것을 탐색하지 않고 다른걸 탐색했다?
            } else {
                System.out.println(0);
                System.exit(0);
            }
        }
    }
}