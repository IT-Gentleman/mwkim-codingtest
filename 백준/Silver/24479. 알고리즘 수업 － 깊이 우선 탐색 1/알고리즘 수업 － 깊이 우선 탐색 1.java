
import java.io.*;
import java.util.*;

/*
의사코드
1. 간선정보가 주어지면, 각 노드에 반대노드 정보를 추가함
 이때, 반대노드 정보들은 어떻게 저장해야하는가?
 1) 최소힙 사용 : heapify에 O(n) 소요, 꺼내는데 O(logn) 소요
 2) 배열 사용 : 최초정렬에 O(nlogn) 소요, 꺼내는데 O(1) 소요
 => 최소힙이 시간복잡도 최소임
2.
 */

public class Main {

    static int N, M, P;
    static List<PriorityQueue<Integer>> pqLst = new ArrayList<>();
    // PriorityQueue<Integer>[] pqArray; 로 사용해도 되나, 지피티씨가 쓰지 말래요
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // idx=0인 곳은 pqLst와 visited에서 사용되지 않음
        for (int i = 0; i <= N; i++) {
            pqLst.add(new PriorityQueue<>());
        }
        visited = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pqLst.get(a).add(b);
            pqLst.get(b).add(a);
        }

        dfs(P);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfs(int nodeID) {
        visited[nodeID] = ++count;

        while (!pqLst.get(nodeID).isEmpty()) {
            int minID = pqLst.get(nodeID).poll(); // 오류와는 달리, 실제로는 isEmpty 검사 수행하기에 문제없음
            if (visited[minID] == 0) {
                dfs(minID);
            }
        }
    }

}