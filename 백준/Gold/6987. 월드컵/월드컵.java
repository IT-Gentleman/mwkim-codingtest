import java.io.*;
import java.util.*;

public class Main {

    // 각 팀의 승무패 기록
    static int[] wins   = new int[6];
    static int[] draws  = new int[6];
    static int[] losses = new int[6];

    // 대진 목록
    static int[][] matches = new int[15][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // matches 초기화
        int idx = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        // 네 줄(네 시나리오) 입력 처리
        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                wins[i] = Integer.parseInt(st.nextToken());
                draws[i] = Integer.parseInt(st.nextToken());
                losses[i] = Integer.parseInt(st.nextToken());
            }

            // 빠른 불가능 판정
            if (!checkPreconditions()) {
                System.out.print("0 ");
                continue;
            }
            // 백트래킹 탐색
            if (dfs(0)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    // 사전 검증: 팀별 경기 수, 승패 대칭, 무승부 짝수성 확인
    private static boolean checkPreconditions() {
        int sumW = 0, sumD = 0, sumL = 0;
        for (int i = 0; i < 6; i++) {
            // 각 팀당 5경기 조건
            if (wins[i] + draws[i] + losses[i] != 5)
                return false;
            sumW += wins[i];
            sumD += draws[i];
            sumL += losses[i];
        }
        // 총 승 == 총 패, 무승부는 짝수여야 함
        if (sumW != sumL || sumD % 2 != 0)
            return false;
        return true;
    }

    // matchIdx번째 경기를 배치해보는 DFS
    private static boolean dfs(int matchIdx) {
        // 15경기 배치 완료 시 남은 카운터가 모두 0이면 true
        if (matchIdx == 15) {
            for (int i = 0; i < 6; i++) {
                if (wins[i] != 0 || draws[i] != 0 || losses[i] != 0) {
                    return false;
                }
            }
            return true;
        }

        int a = matches[matchIdx][0];
        int b = matches[matchIdx][1];

        // 1) a 승 - b 패
        if (wins[a] > 0 && losses[b] > 0) {
            wins[a]--;
            losses[b]--;
            if (dfs(matchIdx + 1))
                return true;
            // false일 경우 원복
            wins[a]++;
            losses[b]++;
        }
        // 2) 무승부
        if (draws[a] > 0 && draws[b] > 0) {
            draws[a]--;
            draws[b]--;
            if (dfs(matchIdx + 1))
                return true;
            // false일 경우 원복
            draws[a]++;
            draws[b]++;
        }
        // 3) b 승 - a 패
        if (wins[b] > 0 && losses[a] > 0) {
            wins[b]--;
            losses[a]--;
            if (dfs(matchIdx + 1))
                return true;
            // false일 경우 원복
            wins[b]++;
            losses[a]++;
        }

        return false;
    }
}