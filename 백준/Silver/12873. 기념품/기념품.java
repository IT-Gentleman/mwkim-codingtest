import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        for (int i = 1; q.size() > 1; i++) {
            long cube = (long) i*i*i;
            int farFrom = (int) ((cube <= q.size()) ? cube : cube % q.size());
            if (farFrom == 0) {
                q.pollLast();
                continue;
            }
            // farFrom 값이 1이라면 제자리 poll, 2라면 1 움직여서 poll, ...
            for (int rotated = 1; rotated < farFrom; rotated++) {
                q.add(q.poll());
            }
            q.poll();
        }

        System.out.print(q.poll());

    }
}