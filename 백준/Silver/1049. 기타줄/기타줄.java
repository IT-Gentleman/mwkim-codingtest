import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int minPackage = Integer.MAX_VALUE;
    static int minSingle = Integer.MAX_VALUE;
    static int cost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
            minSingle = Math.min(minSingle, Integer.parseInt(st.nextToken()));
        }
        cost += (N/6)*(Math.min(minPackage, minSingle*6));
        cost += Math.min(minPackage, (N%6)*minSingle);
        System.out.println(cost);
    }

}