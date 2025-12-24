import java.util.*;

public class Main {
    static int n, m, res = Integer.MAX_VALUE;
    static List<int[]> cctvList = new ArrayList<>();
    // directions: up, down, left, right
    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] >= 1 && matrix[i][j] <= 5) {
                    cctvList.add(new int[]{i, j, matrix[i][j]});
                }
            }
        }
        recur(new ArrayList<>(cctvList), matrix);
        System.out.println(res);
    }

    // count zeros (blind spots)
    static int count(int[][] mat) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    // recursive backtracking
    static void recur(List<int[]> left, int[][] mat) {
        if (left.isEmpty()) {
            res = Math.min(res, count(mat));
            return;
        }
        // copy list and pop last CCTV
        List<int[]> rem = new ArrayList<>(left);
        int[] c = rem.remove(rem.size() - 1);
        int r = c[0], col = c[1], type = c[2];

        // handle each type
        switch (type) {
            case 1: // one direction
                for (int d = 0; d < 4; d++) {
                    int[][] copy = copyMatrix(mat);
                    monitor(copy, r, col, d);
                    recur(rem, copy);
                }
                break;
            case 2: // two opposite directions
                // up & down
            {
                int[][] copy = copyMatrix(mat);
                monitor(copy, r, col, 0);
                monitor(copy, r, col, 1);
                recur(rem, copy);
            }
            // left & right
            {
                int[][] copy = copyMatrix(mat);
                monitor(copy, r, col, 2);
                monitor(copy, r, col, 3);
                recur(rem, copy);
            }
            break;
            case 3: // two perpendicular directions
                int[][] combos3 = {{0, 3}, {3, 1}, {1, 2}, {2, 0}};
                for (int[] combo : combos3) {
                    int[][] copy = copyMatrix(mat);
                    monitor(copy, r, col, combo[0]);
                    monitor(copy, r, col, combo[1]);
                    recur(rem, copy);
                }
                break;
            case 4: // three directions
                for (int skip = 0; skip < 4; skip++) {
                    int[][] copy = copyMatrix(mat);
                    for (int d = 0; d < 4; d++) {
                        if (d == skip) continue;
                        monitor(copy, r, col, d);
                    }
                    recur(rem, copy);
                }
                break;
            case 5: // all directions
                int[][] copy = copyMatrix(mat);
                for (int d = 0; d < 4; d++) {
                    monitor(copy, r, col, d);
                }
                recur(rem, copy);
                break;
        }
    }

    // mark view from (r,c) in direction idx until wall(6)
    static void monitor(int[][] mat, int r, int c, int dirIdx) {
        int nr = r + DIRS[dirIdx][0];
        int nc = c + DIRS[dirIdx][1];
        while (nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if (mat[nr][nc] == 6) break;
            if (mat[nr][nc] == 0) mat[nr][nc] = -1;
            nr += DIRS[dirIdx][0];
            nc += DIRS[dirIdx][1];
        }
    }

    // deep copy matrix
    static int[][] copyMatrix(int[][] src) {
        int[][] dst = new int[n][m];
        for (int i = 0; i < n; i++) dst[i] = Arrays.copyOf(src[i], m);
        return dst;
    }
}