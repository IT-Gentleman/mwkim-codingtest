import java.io.*;
import java.util.*;

/*
1. 한 점을 정해서, 탐색 시작
2. 탐색 과정에서 시작점으로 돌아오면 true
3. 시작점으로 돌아오는 경로가 없다면 다른 점 탐색 시작
 */

public class Main {

    static int N, M;
    static short[][] mapLst;
    static boolean[][] visited;
    static short findVal;
    static int[][] four_way = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mapLst = new short[N][M];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                mapLst[i][j] = (short)(line.charAt(j) - 'A');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapLst[i][j] != -1) {
                    visited = new boolean[N][M];
                    findVal = mapLst[i][j];
                    dfs(i, j, -1);
                }
            }
        }
        System.out.println("No");
    }

    static void dfs(int i, int j, int prohibitedDir) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (k==prohibitedDir) {
                continue;
            }
            int x = i + four_way[k][0];
            int y = j + four_way[k][1];
            if (x >= 0 && x < N && y >= 0 && y < M) {
                if (visited[x][y]) {
                    System.out.println("Yes");
                    System.exit(0);
                }
                if (mapLst[x][y] == findVal) {
                    dfs(x, y,(k+2)%4);
                }
            }
        }
    }
}