import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE)); // 옮긴 횟수는 O(1)로 계산 가능
        if (N <= 20)
            hanoi(N, 1, 3, 2);
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n==0) {
            // 이동할 원판 없음
            return;
        }
        hanoi(n-1, from, via, to);
        // 가장 하위 원판을 to로
        System.out.println(from+" "+to);
        hanoi(n-1, via, to, from);
    }
}