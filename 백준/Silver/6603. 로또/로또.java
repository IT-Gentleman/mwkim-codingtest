import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int[] inputList;
    static int[] madeListWithIndex = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k==0)
                return;

            inputList = new int[k];

            for (int i = 0; i < k; i++) {
                inputList[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            System.out.println();
        }
    }

    static void dfs(int depth) {
        if (depth==6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(inputList[madeListWithIndex[i]]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        int lastIndex;
        if (depth==0) {
            lastIndex = -1;
        } else {
            lastIndex = madeListWithIndex[depth-1];
        }

        for (int i = lastIndex+1; i <= k-6 + lastIndex+1 && i < k; i++) {
            madeListWithIndex[depth] = i;
            dfs(depth+1);
        }
    }
}