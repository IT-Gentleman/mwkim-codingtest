import java.io.*;
import java.util.*;

/*
1. 0,0부터 기록 시작
2. 막힌 곳에 다다르면 백트레킹하면서 0부터 시작해서 +1씩 더한값을 visited(boolean 아님)에 기록
3. 백트레킹하다가 추가경로 발견 시, 해당경로까지 모두 탐색한 뒤에 2를 수행하고, 최댓값을 교차로에 기록
4. 3 또는 이후에도 탐색하다가 이미 기록된곳 발견하면, 단순히 해당값 더하고서 백트레킹 시작

예시
a->b->c->d 존재하고, b->e->f->d 존재한다고 가정하면
최초 기록할때는 d까지 들어갔다가 d=0, c=1 기록하고, b에서 새로운 갈래 아직 남아서 계속 탐색 (b의 후보는 2)
b->e->f 탐색한 뒤에 d를 보니 이미 탐색됨, 값은 0임
따라서 d에 새로 기록될 값은 d값 그 자체, f는 d값+1, e는 d값+2, b는 d값+3(=3)
더이상 b의 갈래가 없기에, b의 후보인 2와 3 중 최댓값인 3 저장해놓고, 백트래킹할때도 이 최댓값 기준 진행 => a에는 b+1 기록 = 4
 */

public class Main {

    static int N;
    static int[][] mapLst; // 최대값이 1,000,000 이기에 short 사용불가
    static int[][] visited;
    static int maxCnt = 0;

    static int[][] fourMove = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        mapLst = new int[N][N];
        visited = new int[N][N];


        // 정점번호가 1부터 N까지이기에, 0부터 N까지 N+1개를 확보해두고, idx0은 미사용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mapLst[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    //System.out.println("start from " + i + " " + j);
                    maxCnt = Math.max(maxCnt, dfs(i, j));
                }
            }
        }
        System.out.println(maxCnt);
    }

    static int dfs(int nX, int nY) {
        //System.out.println(nX + " " + nY);
        List<Integer> recordCandidates = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            int x = nX + fourMove[k][0];
            int y = nY + fourMove[k][1];
            if (x >= 0 && x < N && y >= 0 && y < N && mapLst[x][y] > mapLst[nX][nY]) { // 범위체크
                if (visited[x][y] > 0) { // 이미 탐색된 곳임
                    recordCandidates.add(visited[x][y]+1);
                } else {
                    //System.out.println("calling from " + nX + " " + nY + " to " + x + " " + y);
                    recordCandidates.add(dfs(x, y)+1);
                }
            }
        }
        if (!recordCandidates.isEmpty()) {
            int maxVal = recordCandidates.stream().max(Integer::compareTo).get();
            visited[nX][nY] = maxVal;
            return maxVal;
        } else {
            return 1;
        }
    }
}