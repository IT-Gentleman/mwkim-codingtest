import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new long[N+1][2];
        // 각 0과 1이 존재할 수 있는 경우의 수를 기록

        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            // 직전에 1이었으면 0밖에 못씀
            dp[i][0] = dp[i-1][1]+dp[i-1][0];
            // 직전에 0이었으면 두 숫자 0/1 모두 사용 가능
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N][1]+dp[N][0]);
    }
}