import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, Queue<Integer>> sushiToCustomers = new HashMap<>();
        int[] custEatCount = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = scanner.nextInt();
            for (int j = 0; j < cnt; j++) {
                int sushiId = scanner.nextInt();
                sushiToCustomers.putIfAbsent(sushiId, new LinkedList<>());
                sushiToCustomers.get(sushiId).add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            int sushiId = scanner.nextInt();
            Queue<Integer> customers = sushiToCustomers.get(sushiId);
            if (customers != null && !customers.isEmpty()) {
                int custIdx = customers.poll();
                custEatCount[custIdx]++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(custEatCount[i] + " ");
        }
    }
}