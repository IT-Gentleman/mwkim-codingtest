import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        paper = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(paper[i], ' ');
        }

        divide(0, 0, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(paper[i]);
            bw.newLine();
        }
        bw.flush();
    }

    static void divide(int row, int col, int size) {
        if (size == 1) {
            paper[row][col] = '*';
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;
                divide(row+i*newSize, col+j*newSize, newSize);
            }
        }
    }
}