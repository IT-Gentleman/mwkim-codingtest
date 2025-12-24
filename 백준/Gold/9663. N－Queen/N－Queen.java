import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int res = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N];

        recur(0);

        System.out.println(res);
    }

    static void recur(int row) {
        if (row == N) { // 모든 퀸 배치함
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[row] = i;
            if (isValid(row)) {
                recur(row + 1);
            }
        }
    }

    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[i]-board[row])==row-i) {
                // 같은 열이거나, 대각선에 존재 (row>i)
                return false;
            }
        }
        return true;
    }
}