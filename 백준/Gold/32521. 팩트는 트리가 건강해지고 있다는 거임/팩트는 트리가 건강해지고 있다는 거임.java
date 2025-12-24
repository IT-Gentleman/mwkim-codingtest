import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static List<List<Integer>> adjList;
    static boolean[] visited;

    static List<PriorityQueue<Integer>> nodeAdjUnhealthy = new ArrayList<>();
    static int[] nodeUnhealthySum;
    static int[] parentNode;
    static int[] outdegree;
    static Queue<Integer> outdegreeZeroQueue = new LinkedList<>();

    static int removedLink = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();
        visited = new boolean[N];

        nodeUnhealthySum = new int[N];
        parentNode = new int[N];
        outdegree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nodeAdjUnhealthy.add(new PriorityQueue<>(Collections.reverseOrder()));
            adjList.add(new ArrayList<>());
            int input = Integer.parseInt(st.nextToken());
            if (input == 1) {
                nodeUnhealthySum[i] = 1;
            }
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // root를 1 (idx=0)로 잡고 트리를 재건축합니다.
        buildTree(0);

        for (int i = 0; i < N; i++) {
            if (outdegree[i] == 0) {
                outdegreeZeroQueue.add(i);
            }
        }

        while (!outdegreeZeroQueue.isEmpty()) {
            int node = outdegreeZeroQueue.poll();
            while (nodeUnhealthySum[node] > K) {
                nodeUnhealthySum[node] -= nodeAdjUnhealthy.get(node).poll();
                removedLink++;
            }
            if (nodeUnhealthySum[node] > 0) {
                nodeAdjUnhealthy.get(parentNode[node]).add(nodeUnhealthySum[node]);
                nodeUnhealthySum[parentNode[node]] += nodeUnhealthySum[node];
            }
            if (--outdegree[parentNode[node]] == 0) {
                outdegreeZeroQueue.add(parentNode[node]);
            }
        }

        System.out.println(removedLink);

    }

    static void buildTree(int parent) {
        visited[parent] = true;
        for (int node : adjList.get(parent)) {
            if (!visited[node]) {
                parentNode[node] = parent;
                outdegree[parent]++;
                buildTree(node);
            }
        }
    }
}