import java.io.*;
import java.util.*;

public class Main {

    static class Lect {
        int pay, day;
        public Lect(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    static int N, K;
    static List<Lect> lects = new ArrayList<>();
    static boolean[] didLect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        didLect = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lects.add(new Lect(pay, day));
        }

        lects.sort(Comparator.comparingInt(lect -> lect.day));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lect lect : lects) {
            pq.offer(lect.pay);
            if (pq.size() > lect.day) pq.poll();
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}