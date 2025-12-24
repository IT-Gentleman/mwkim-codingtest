import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] stdLst;
    static int[] visitDepth;
    static int[] visitMark;
    static int notInTeam;
    static int prevPnt, newPnt;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // 학생번호가 1부터 N까지이기에, 0부터 N까지 N+1개를 확보해두고, idx0은 미사용
            stdLst = new int[N+1];
            notInTeam = 0;
            visitMark = new int[N+1];
            visitDepth = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stdLst[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (visitMark[i] == 0) {
                    prevPnt = i;
                    depth = 0;
                    while (true) {
                        newPnt = stdLst[prevPnt];
                        visitMark[prevPnt] = i;
                        if (newPnt == prevPnt) {
                            notInTeam += depth;
                            break;
                        }
                        if (visitMark[newPnt] == i) {
                            // 이 루프에서 방문한 기록이 있음
                            notInTeam += visitDepth[newPnt]-1;
                            break;
                        }
                        if (visitMark[newPnt] > 0) {
                            // 다른 루프에서 발견됨
                            notInTeam += depth+1;
                            break;
                        }
                        visitDepth[prevPnt] = ++depth;
                        prevPnt = newPnt;
                    }
                }
            }
            System.out.println(notInTeam);
        }
    }
}