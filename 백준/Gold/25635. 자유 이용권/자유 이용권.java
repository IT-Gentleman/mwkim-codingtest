import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long total = 0, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(st.nextToken());
            total += value;
            if (value > max) max = value;
        }
        long rest = total - max;
        long result = (max <= rest + 1)? total : 2 * rest + 1;
        System.out.println(result);
    }
}