import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recur();
    }

    static void recur() {
        if (stack.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (int n : stack)
                sb.append(n).append(" ");
            System.out.println(sb.toString().trim());
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!stack.contains(i)) {
                stack.push(i);
                recur();
                stack.pop();
            }
        }
    }
}