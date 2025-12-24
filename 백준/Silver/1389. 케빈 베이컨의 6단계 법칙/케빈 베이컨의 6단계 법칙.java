import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    //static boolean[][] connected; // N*N해도 10000으로써 친구관계의 2배밖에 되지 않음. 구현편의를 위해 이와같이 사용
    static int[][] distance; // from -> to 간의 상관관계

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //connected = new boolean[N][N];
        distance = new int[N+1][N+1];
        // 1부터 N까지의 인덱싱 사용

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // connected 대신 distance 만으로 구현 가능 (==0 검증 수행)
            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        for (int via = 1; via <= N; via++) {
            for (int from = 1; from <= N; from++) {
                for (int to = from+1; to <= N; to++) {
                    // 기존 플로이드-워셜 알고리즘에서,
                    // from < to 인 경우만 탐색하도록 변경하여,
                    // dist[from][to]와 dist[to][from] 모두 업데이트 수행
                    // 이는 무방향 그래프이기 때문에 사용할 수 있는 기작

                    // 같은 노드이거나 연결되어있지 않은 경우 pass
                    if (via==from || to==via || distance[from][via]==0 || distance[via][to]==0)
                        continue;
                    int newDistance = distance[from][via] + distance[via][to];
                    if (distance[from][to]==0 || distance[from][to] > newDistance) {
                        distance[from][to] = newDistance;
                        distance[to][from] = newDistance;
                    }
                }
            }
        }

        int minBacon = Integer.MAX_VALUE;
        int minBaconIndex = Integer.MAX_VALUE;
        for (int from = 1; from <= N; from++) {
            int kevinBacon = 0;
            for (int to = 1; to <= N; to++) {
                kevinBacon += distance[from][to];
            }
            if (kevinBacon < minBacon) {
                minBacon = kevinBacon;
                minBaconIndex = from;
            }// else if (kevinBacon == minBacon) {}
            // 앞에서 kevinBacon이 나왔다면, 그 뒤의 index는 어차피 정답이 될 수 없으므로 검사할 필요 없음
        }
        System.out.println(minBaconIndex);

    }

}