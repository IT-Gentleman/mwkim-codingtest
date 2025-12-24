import java.io.*;
import java.util.*;

public class Main {

    static int N, root, toErase;
    static List<List<Integer>> adjLst = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            adjLst.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                root = i;
            } else {
                adjLst.get(a).add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        toErase = Integer.parseInt(st.nextToken());

        dfs(root, adjLst.get(root).size() == 1);

        System.out.println(count);
    }

    static void dfs(int nodeID, boolean isWedong) {
        if (nodeID == toErase) {
            if (isWedong) {
                count++;
            }
            return;
        }
        if (adjLst.get(nodeID).isEmpty()) {
            count++;
        } else {
            for (int i = 0; i < adjLst.get(nodeID).size(); i++) {
                dfs(adjLst.get(nodeID).get(i), adjLst.get(nodeID).size() == 1);
            }
        }
    }

}