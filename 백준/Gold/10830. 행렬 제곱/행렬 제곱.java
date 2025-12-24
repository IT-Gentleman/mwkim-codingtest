import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long M;

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] i : divide(M)) {
            for (int j : i) {
                System.out.print(j%1000 + " ");
            }
            System.out.println();
        }

    }

    static int[][] divide(long toMul) {
        if (toMul == 1) {
            return matrix;
        }

        if (toMul % 2 == 0) {
            return matrixSquareMultiply(divide(toMul / 2));
        } else {
            return matrixMultiply(matrixSquareMultiply(divide(toMul / 2)));
        }
    }

    static int[][] matrixSquareMultiply(int[][] mat) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + mat[i][k] * mat[k][j]) % 1000;
                }
            }
        }
        return result;
    }

    static int[][] matrixMultiply(int[][] mat) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + matrix[i][k] * mat[k][j]) % 1000;
                }
            }
        }
        return result;
    }
}