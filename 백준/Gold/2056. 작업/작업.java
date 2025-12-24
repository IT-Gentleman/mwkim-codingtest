import java.io.*;
import java.util.*;

public class Main {

    static class Work {
        int time;
        int indegree = 0;
        int whenIndegreeDecreased = 0;
        Set<Integer> outdegrees = new HashSet<>();
    }

    static int N;
    static Work[] works;
    static PriorityQueue<Work> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.whenIndegreeDecreased));
    static int maxTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        works = new Work[N+1];
        for (int i = 1; i <= N; i++) {
            works[i] = new Work();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int indegree = Integer.parseInt(st.nextToken());
            works[i].time = time;
            works[i].indegree = indegree;
            for (int j = 0; j < indegree; j++) {
                int vertex = Integer.parseInt(st.nextToken());
                works[vertex].outdegrees.add(i);
            }
            if (indegree == 0) {
                pq.add(works[i]);
            }
        }

        int time;
        while (!pq.isEmpty()) {
            Work work = pq.poll();
            time = work.whenIndegreeDecreased + work.time;
            maxTime = Math.max(maxTime, time);
            for (int i : work.outdegrees) {
                works[i].whenIndegreeDecreased = Math.max(works[i].whenIndegreeDecreased, time);
                works[i].indegree--;
                if (works[i].indegree==0) {
                    pq.add(works[i]);
                }
            }
        }
        System.out.println(maxTime);
    }
}