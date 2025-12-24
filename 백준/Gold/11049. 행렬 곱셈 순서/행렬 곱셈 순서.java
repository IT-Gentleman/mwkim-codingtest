import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][][] dp; // from, to, MulCnt/r/c

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][i][1] = Integer.parseInt(st.nextToken());
            dp[i][i][2] = Integer.parseInt(st.nextToken());
        }

        for (int len = 2; len <= N; len++) {
            // i는 시작지점을 의미
            for (int i = 0; i + len <= N; i++) {
                // j는 종료지점을 의미
                int j = i + len - 1;
                dp[i][j][0] = Integer.MAX_VALUE;
                // k는 중간 슬라이스 지점으로, 왼쪽 슬라이스의 끝을 가리킴
                for (int k = i; k < j; k++) {
                    assert dp[i][k][2]==dp[k+1][j][1];
                    // 연산하는데 총 소요되는 횟수는 다음과 같음
                    /*
                        왼쪽 행렬의 row 크기
                        * 두 행렬의 접점 (왼쪽행렬의 col, 오른쪽행렬의 row) 크기
                        * 오른쪽 행렬의 col 크기
                        + 왼쪽 행렬을 계산하는데 소요된 연산횟수
                        + 오른쪽 행렬을 계산하는데 소요된 연산횟수
                     */
                    if (dp[i][j][0] > dp[i][k][1]*dp[i][k][2]*dp[k+1][j][2]+dp[i][k][0]+dp[k+1][j][0]) {
                        dp[i][j][0] = dp[i][k][1]*dp[i][k][2]*dp[k+1][j][2]+dp[i][k][0]+dp[k+1][j][0];
                        dp[i][j][1] = dp[i][k][1];
                        dp[i][j][2] = dp[k+1][j][2];
                    }
                }
            }
        }
        System.out.println(dp[0][N-1][0]);
    }
}