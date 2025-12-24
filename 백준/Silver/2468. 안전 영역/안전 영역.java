
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    // 4방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    // 8방향
    //static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    //static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int maxCon = 0;
        for (int height = 1; height <= 100; height++) {
            visited = new boolean[n][n];
            int connected = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= height && !visited[i][j]) {
                        bfs(i, j, height);
                        connected++;
                    }
                }
            }
            if (connected == 0)
                break;
            maxCon = Math.max(maxCon, connected);
        }
        System.out.println(maxCon);
    }

    static void bfs(int x, int y, int height) {
        
        visited[x][y] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
                int nx = cx + dx[dirIdx];
                int ny = cy + dy[dirIdx];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] >= height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}