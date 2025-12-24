import java.io.*;
import java.util.*;

public class Main {

    static int s, N, K, r1, r2, c1, c2;
    static char[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        paper = new char[r2 - r1 + 1][c2 - c1 + 1];
        for (char[] chars : paper) {
            Arrays.fill(chars, '0');
        }

        divide(r1, r2, c1, c2, 0, 0, pow(N, s));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char[] line : paper) {
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
    }

    static int pow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    static boolean isInBlack(int from, int to, int r, int c) {
        return (from <= r && r <= to && from <= c && c <= to);
    }

    // from/to는 해당 프렉탈의 from/to를 의미하며, paperR/C는 실제 출력 paper의 시작위치를 의미함
    static void divide(int fromR, int toR, int fromC, int toC, int paperR, int paperC, int size) {
        if (size == N) {
            // 단위공간 출력
            // 어디부터 어디까지가 검정색인것인가?
            int fromBlack = (N-K)/2, toBlack = fromBlack+K-1;
            for (int i = fromR; i <= toR; i++) {
                for (int j = fromC; j <= toC; j++) {
                    paper[paperR + (i-fromR)][paperC + (j-fromC)] = isInBlack(fromBlack, toBlack, i, j) ? '1' : '0';
                }
            }
            return;
        }
        int newSize = size / N;
        int fromBlack = (N-K)/2, toBlack = fromBlack+K-1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 프렉탈 조각의 범위 명시
                int startRow = i * newSize, startCol = j * newSize;
                int toRow = (i + 1) * newSize-1, toCol = (j + 1) * newSize-1;
                // 범위에 해당하는지 검증 (끝이 프렉탈시작보다 전이거나, 시작이 프렉탈끝보다 이후일 경우)
                if (toR < startRow || toC < startCol || fromR > toRow || fromC > toCol)
                    continue;
                // 이 이하가 실행됨의 의미는, from/to가 각 row/col 모두에 대해서 범위 내에 존재한다는 것
                int newFromRow = Math.max(0, fromR-startRow), newFromCol = Math.max(0, fromC-startCol);
                int newToRow = Math.min(newSize-1, toR-startRow), newToCol = Math.min(newSize-1, toC-startCol);
                int newPaperR = paperR + Math.max(0, startRow-fromR);
                int newPaperC = paperC + Math.max(0, startCol-fromC);

                if (isInBlack(fromBlack, toBlack, i, j)) {
                    for (int i1 = newFromRow; i1 <= newToRow; i1++) {
                        for (int j1 = newFromCol; j1 <= newToCol; j1++) {
                            paper[newPaperR+(i1-newFromRow)][newPaperC+(j1-newFromCol)] = '1';
                        }
                    }
                    continue;
                }

                divide(newFromRow, newToRow, newFromCol, newToCol, newPaperR, newPaperC, newSize);
            }
        }
    }
}