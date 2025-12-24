import java.io.*;
import java.util.*;

public class Main {

    static String A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;

        A = br.readLine();
        B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        // Backtracking to get the LCS string
        StringBuilder sb = new StringBuilder();
        int i = A.length(), j = B.length();
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                sb.append(A.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        sb.reverse();
        System.out.println(dp[A.length()][B.length()]);
        System.out.println(sb.toString());
    }
}