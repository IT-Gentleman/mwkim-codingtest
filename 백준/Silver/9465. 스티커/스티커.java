import java.io.*;
import java.util.*;

public class Main {

    static int T, n;
    static int[][] stickerScore;
    static int[][] dpScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            stickerScore = new int[2][n];
            dpScore = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    stickerScore[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < 2; j++) {
                    dpScore[j][k] = maxScore(j, k);
                }
            }

            System.out.println(Math.max(dpScore[0][n-1], dpScore[1][n-1]));
        }

    }

    public static int maxScore(int row, int col) {
        if (col == 0) {
            return stickerScore[row][col];
        } else if (col == 1) {
            return dpScore[(row+1)%2][col-1] + stickerScore[row][col];
        } else {
            return Math.max(dpScore[(row+1)%2][col-1], dpScore[(row+1)%2][col-2]) + stickerScore[row][col];
        }
    }
}