
import java.util.*;

public class Main {
    static int[] board = new int[100+1];
    static int[] cost = new int[100+1];
    static boolean[] visited = new boolean[100+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int latter = sc.nextInt();
        int snake = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < latter; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            sc.nextLine();
            board[from] = to;
        }
        for (int i = 0; i < snake; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            sc.nextLine();
            //visited[from] = true;
            board[from] = to;
        }
        bfs();
        System.out.println(cost[100]);
    }

    static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int curCost = cost[cur];
            for (int dice = 1; dice <= 6; dice++) {
                int newPos = cur + dice;
                if (newPos > 100){
                    continue;
                }
                if (!visited[newPos]) {
                    visited[newPos] = true;
                    cost[newPos] = curCost + 1;
                    if (board[newPos] != 0) { // 이동경로 존재
                        newPos = board[newPos];
                        if (!visited[newPos]) {
                            visited[newPos] = true;
                            cost[newPos] = curCost + 1;
                        } else {
                            continue;
                        }
                    }
                    if (newPos == 100) {
                        return;
                    }
                    q.add(newPos);
                }
            }
        }
    }
}