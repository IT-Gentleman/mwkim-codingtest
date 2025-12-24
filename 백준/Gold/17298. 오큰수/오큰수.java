import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Map.Entry<Integer, Integer>> toFind = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        // heap과 유사한 기능 수행, value 기준으로 오름차순 정렬됨
        List<Integer> nge = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            nge.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            // 비지 않았고, 최소값이 현재 값보다 더 작을 때 (nge 업데이트 필요 시) 수행
            while (!toFind.isEmpty() && toFind.peek().getValue() < nge.get(i)) {
                nge.set(toFind.poll().getKey(), nge.get(i));
            }
            toFind.add(new AbstractMap.SimpleEntry<>(i, nge.get(i))); //idx, value
        }
        for (Map.Entry<Integer, Integer> entry : toFind) {
            nge.set(entry.getKey(), -1);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nge) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}