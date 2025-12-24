import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] board;
    static boolean[][] snaked;
    static Deque<int[]> snake;
    static int directionIdx;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new boolean[n][n];
        snaked = new boolean[n][n];
        snake = new ArrayDeque<>();
        directionIdx = 0;

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row-1][col-1] = true;
        }

        snake.addFirst(new int[]{0, 0});
        snaked[0][0] = true;

        int l = Integer.parseInt(br.readLine());
        int[] changeTiming = new int[l];
        char[] changeDir = new char[l];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            changeTiming[i] = Integer.parseInt(st.nextToken());
            changeDir[i] = st.nextToken().charAt(0);
        }

        int prevSec = 0;
        for (int i = 0; i < l; i++) {
            int nextSec = changeTiming[i];
            int timeSlip = nextSec - prevSec;

            for (int j = 0; j < timeSlip; j++) {
                if (!moveHead()){
                    System.out.println(prevSec + j + 1);
                    return;
                }
            }

            directionIdx = (changeDir[i]=='D') ? (directionIdx + 1) % 4 : (directionIdx - 1 + 4) % 4;
            prevSec = nextSec;
        }

        while (true) {
            prevSec++;
            if (!moveHead()){
                System.out.println(prevSec);
                return;
            }
        }
    }
    static boolean moveHead() {
        int[] head = snake.peekFirst();
        int newRow = head[0] + directions[directionIdx][0];
        int newCol = head[1] + directions[directionIdx][1];

        if (!(0 <= newRow && newRow < n && 0 <= newCol && newCol < n) || snaked[newRow][newCol]) {
            return false;
        }

        snake.addFirst(new int[]{newRow, newCol});
        snaked[newRow][newCol] = true;

        if (!board[newRow][newCol]) {
            int[] tail = snake.pollLast();
            snaked[tail[0]][tail[1]] = false;
        }
        else {
            board[newRow][newCol] = false;
        }
        return true;
    }
}