import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static short[][] map;
    static int whitePaper = 0, bluePaper = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new short[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Short.parseShort(st.nextToken());
            }
        }
        recur(0, 0, N);
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    static void recur(int sR, int sC, int size) {
        int sum = 0;
        for (int i = sR; i < sR + size; i++) {
            for (int j = sC; j < sC + size; j++) {
                sum += map[i][j];
            }
        }
        if (sum==0) {
            whitePaper++;
            return;
        } else if (sum==size*size) {
            bluePaper++;
            return;
        }
        size /= 2;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j ++)
                recur(sR+size*i, sC+size*j, size);
    }

}