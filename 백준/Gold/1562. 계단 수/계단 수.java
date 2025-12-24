import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int result = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N+1][10][10][1024];

        int length, from, to, visited;
        //length = 1;
        for (int u = 1; u <= 9; u++) {
            dp[1][u][u][1 << u] = 1;
        }
        for (length = 1; length < N; length++) {
            for (from = 1; from <= 9; from++) {
                //to = 0;
                for (visited = 0; visited < 1024; visited++) {
                    dp[length+1][from][1][visited | (1 << 1)] = (dp[length][from][0][visited] + dp[length+1][from][1][visited | (1 << 1)])%1000000000;
                }
                for (to = 1; to <= 8; to++) {
                    for (visited = 0; visited < 1024; visited++) {
                        dp[length+1][from][to-1][visited | (1 << to-1)] = (dp[length][from][to][visited] + dp[length+1][from][to-1][visited | (1 << to-1)])%1000000000;
                        dp[length+1][from][to+1][visited | (1 << to+1)] = (dp[length][from][to][visited] + dp[length+1][from][to+1][visited | (1 << to+1)])%1000000000;
                    }
                }
                //to = 9;
                for (visited = 0; visited < 1024; visited++) {
                    dp[length+1][from][8][visited | (1 << 8)] = (dp[length][from][9][visited] + dp[length+1][from][8][visited | (1 << 8)])%1000000000;
                }
            }
        }

        for (from = 1; from <= 9; from++) {
            for (to = 0; to <= 9; to++) {
                result = (dp[N][from][to][1023] + result)%1000000000;
            }
        }
        System.out.println(result);
    }
}