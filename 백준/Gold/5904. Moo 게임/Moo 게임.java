import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> l = new ArrayList<>(List.of(3));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int last = 3;
        while (last < N) {
            last = last*2 + l.size() + 3; // 지난값 2배, k+3만큼을 더한 값인데, 이때 k는 l.size()와 동일
            //System.out.println(last);
            l.add(last);
        }

        divide(N, l.size()-1);
    }

    static void divide(int bunjae, int listIdx) {
        if (listIdx == 0) {
            if (bunjae == 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
            System.exit(0);
        }
        if (bunjae <= l.get(listIdx-1)) {
            divide(bunjae, listIdx-1);
        } else if (bunjae <= l.get(listIdx-1) + listIdx + 3) {
            if (bunjae == l.get(listIdx-1)+1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
            System.exit(0);
        } else {
            divide(bunjae - (l.get(listIdx-1) + listIdx + 3), listIdx-1);
        }
    }
}