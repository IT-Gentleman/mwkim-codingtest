import java.io.*;
import java.util.*;

public class Main {

    static int T, K;
    static int[][] dp;
    static int[] input;
    static int[] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            dp = new int[K][K];
            input = new int[K];
            prefix = new int[K+1];

            prefix[0] = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                prefix[i+1] = prefix[i] + input[i];
            }


            for (int len = 2; len <= K; len++) {
                // i는 시작지점
                for (int i = 0; i + len <= K; i++) {
                    // j는 종료지점
                    int j = i + len - 1;
                    // k는 중간 슬라이스 지점으로, 왼쪽 슬라이스의 끝임
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + prefix[j+1]-prefix[i]);
                    }
                }
            }
            System.out.println(dp[0][K-1]);
        }
    }
}