import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] paper;
    static int[] count = new int[3]; // 각 -1, 0, 1 사용 => 값에 +1 한 값을 idx로 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        for (int cnt : count) {
            System.out.println(cnt);
        }
    }

    static void divide(int row, int col, int size) {
        if (isAllSame(row, col, size)) {
            // size==1인것 별도 검사할 필요 없이, 공통적으로 isAllSame 진입
            count[paper[row][col]+1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(row+i*newSize, col+j*newSize, newSize);
            }
        }
    }

    static boolean isAllSame(int row, int col, int size) {
        int value = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}