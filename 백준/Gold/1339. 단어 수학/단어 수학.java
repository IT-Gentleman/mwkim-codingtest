import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<Character, Integer> charCnt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                charCnt.put(c, charCnt.getOrDefault(c, 0) + pow(10, line.length()-j - 1));
                //System.out.println(c + " " + charCnt.get(c));
            }
        }

        List<Integer> values = new ArrayList<>(charCnt.values());
        values.sort(Comparator.reverseOrder());  // 내림차순 정렬

        int res = 0;
        int val = 9;
        for (int i = 0; i < values.size(); i++) {
            //System.out.println(values.get(i) + " " + val);
            res += values.get(i)*val--;
        }
        System.out.println(res);

    }

    static int pow (int base, int exp) {
        int res = 1;
        for (int i = 1; i <= exp; i++) {
            res *= base;
        }
        return res;
    }
}