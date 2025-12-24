
import java.util.*;

public class Main {
    static int m, n, k;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        // 각 테스트케이스에 대해 수행
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            sc.nextLine();

            field = new int[m][n];
            visited = new boolean[m][n];
            
            // 배추가 심어진 위치 기록
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                field[x][y] = 1;
            }

            int count = 0; // 지렁이
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    // 배추가 있는데 아직 탐색되지 않았다면
                    if (field[j][l] == 1 && !visited[j][l]) {
                        // 연결된 배추들 모두 찾아서 기록하고, 총 필요한 지렁이는 단 하나
                        bfs(j, l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
                int nx = curX + dx[dirIdx];
                int ny = curY + dy[dirIdx];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (field[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}