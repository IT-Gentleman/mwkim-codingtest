import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] postOrder;
    static int[] inOrder;
    static int postOrderIdx;

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    static Node treeRoot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        inOrder = new int[n];
        postOrder = new int[n];
        postOrderIdx = n-1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        preOrderRecur(buildTreeRecur(0, n-1), sb);
        System.out.println(sb.toString());
    }

    public static int indexInRange(int root, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == root)
                return i;
        }
        return -1;
    }

    static Node buildTreeRecur(int inStart, int inEnd) {
        if (postOrderIdx == -1)
            return null;
        int root = postOrder[postOrderIdx];
        int rootIdx = indexInRange(root, inStart, inEnd);
        if (rootIdx == -1)
            return null;
        Node rootNode = new Node(root);
        // inOrder 상에서 root가 존재할때만 root 제거 후 계속
        postOrderIdx--;
        // 오른쪽 먼저 순회해야함
        rootNode.right = buildTreeRecur(rootIdx+1, inEnd);
        rootNode.left = buildTreeRecur(inStart, rootIdx-1);
        return rootNode;
    }

    static void preOrderRecur(Node root, StringBuilder sb) {
        sb.append(root.val).append(" ");
        if (root.left != null)
            preOrderRecur(root.left, sb);
        if (root.right != null)
            preOrderRecur(root.right, sb);
    }
}