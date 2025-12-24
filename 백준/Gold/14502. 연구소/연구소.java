
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static List<int[]> emptySlt = new ArrayList<>();
    static List<int[]> virusSlt = new ArrayList<>();


    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int minExtraVirusedArea = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    emptySlt.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    virusSlt.add(new int[]{i, j});
                }
            }
            sc.nextLine();
        }

        int emptySize = emptySlt.size();

        for (int firstWall = 0; firstWall < emptySize; firstWall++) {
            for (int secondWall = firstWall+1; secondWall < emptySize; secondWall++) {
                for (int thirdWall = secondWall+1; thirdWall < emptySize; thirdWall++) {
                    simulateWallNSpread(
                            emptySlt.get(firstWall),
                            emptySlt.get(secondWall),
                            emptySlt.get(thirdWall)
                    );
                }
            }
        }

        System.out.println(emptySize - minExtraVirusedArea - 3); // 3은 벽 세운 곳만큼 제외
    }

    static int[][] copyMap(int[][] originMap) {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            newMap[i] = Arrays.copyOf(originMap[i], m);
        }
        return newMap;
    }

    static void simulateWallNSpread(int[] p1, int[] p2, int[] p3) {
        int[][] newSimMap = copyMap(map);
        int extraVirusedArea = 0;

        newSimMap[p1[0]][p1[1]] = 1;
        newSimMap[p2[0]][p2[1]] = 1;
        newSimMap[p3[0]][p3[1]] = 1;

        Queue<int[]> q = new LinkedList<>();
        for (int[] virus : virusSlt) {
            q.offer(new int[]{virus[0], virus[1]});
        }
        while (!q.isEmpty()) {
            int[] virus = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = virus[0]+dr[dir];
                int nc = virus[1]+dc[dir];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && newSimMap[nr][nc] == 0) {
                    newSimMap[nr][nc] = 3; // 감염됨
                    extraVirusedArea++;
                    if (extraVirusedArea > minExtraVirusedArea) {
                        return; // 가지치기, 정답이 될 가능성 없음
                    }
                    q.add(new int[]{nr, nc});
                }
            }
        }
        minExtraVirusedArea = Math.min(minExtraVirusedArea, extraVirusedArea);
    }

}