
import java.util.*;

public class Main {
    static int n, m, h;
    static int[][][] box;
    static int raw = 0;

    static Queue<int[]> q = new LinkedList<>();

    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        sc.nextLine();
        box = new int[h][n][m]; // 높이(층)/행/열 순으로 접근

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    } else if (box[i][j][k] == 0) {
                        raw++;
                    }
                }
                sc.nextLine();
            }
        }

        int result = bfs();
        if (raw != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result-1);
        }
    }

    static int bfs() {
        int maxDate = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int r = cur[1];
            int c = cur[2];
            int nowDate = box[z][r][c];

            for (int dirIdx = 0; dirIdx < 6; dirIdx++) {
                int nz = z + dh[dirIdx];
                int nr = r + dr[dirIdx];
                int nc = c + dc[dirIdx];

                if (nz >= 0 && nz < h && nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (box[nz][nr][nc] == 0) {
                        raw--;
                        box[nz][nr][nc] = nowDate + 1;
                        q.add(new int[]{nz, nr, nc});
                        maxDate = Math.max(maxDate, nowDate + 1);
                    }
                }
            }
        }
        return maxDate;
    }
}