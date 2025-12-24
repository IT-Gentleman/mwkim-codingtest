import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int sumD = 0;
    static int sumV = 0;
    static int maxT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int playtime = sumD;
            sumD += Integer.parseInt(st.nextToken());
            sumV += Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT, sumV-playtime);
        }

        System.out.println(maxT);
    }
}