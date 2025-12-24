import java.io.*;
import java.util.*;

public class Main {

    static String preOrder, inOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            preOrder = st.nextToken();
            inOrder = st.nextToken();

            System.out.println(seekTreeRecursive(inOrder));
        }

    }

    // 결과 String 반환
    public static String seekTreeRecursive(String in) {
        if (preOrder.isEmpty()) {
            return "";
        }
        char root = preOrder.charAt(0);
        int rootIdx = in.indexOf(root);
        if (rootIdx == -1) {
            return "";
        }
        // inOrder 상에서 root가 존재할때만 root 제거 후 계속
        preOrder = preOrder.substring(1);
        return seekTreeRecursive(in.substring(0, rootIdx))
                + seekTreeRecursive(in.substring(rootIdx + 1))
                + root;
    }
}