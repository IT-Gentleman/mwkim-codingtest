import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] TP;
    static int[] best;
    static int top = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TP = new int[N][2];
        best = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            TP[i][0] = Integer.parseInt(st.nextToken());
            TP[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            // 직전날들의 결과가 현재 결과보다 더 좋으면, 가져와야합니다. (직전날 - 금일 사이에 휴식 상정)
            if (i > 0) {
                best[i] = Math.max(best[i-1], best[i]);
            }
            // 상담 진행해도 날짜 지나지 않고, 상담 종료시기에 기록되어있는 기존 최고값을 경신하는 경우에 새로 기록
            if (i + TP[i][0] < N && best[i+TP[i][0]] < best[i]+TP[i][1]) {
                best[i+TP[i][0]] = best[i]+TP[i][1];
                top = Math.max(top, best[i] + TP[i][1]);
            }
            // 상담 진행했을 때 날짜가 딱 끝나고 (즉 이 값에 대해 memoization 불필요), 이 값이 top보다 더 클때 top만 갱신
            else if (i + TP[i][0] == N && top < best[i] + TP[i][1]) {
                top = best[i] + TP[i][1];
            }
        }
        System.out.println(top);

    }
}