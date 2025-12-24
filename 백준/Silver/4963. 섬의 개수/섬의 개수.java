
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;


    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt(); // x에 대응됨
            h = sc.nextInt(); // y에 대응됨
            if (w == 0 && h == 0) break;
            sc.nextLine();

            map = new int[w][h];
            for (int j = 0; j < h; j++) {
                for (int i = 0; i < w; i++) {
                    map[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }

            int count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int dirIdx = 0; dirIdx < 8; dirIdx++) {
                int nx = cx + dx[dirIdx];
                int ny = cy + dy[dirIdx];

                if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}