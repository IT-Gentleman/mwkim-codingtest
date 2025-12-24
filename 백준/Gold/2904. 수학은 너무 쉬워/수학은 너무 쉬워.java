import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] inputList;
    static List<Integer> sosuList = new ArrayList<>();
    static int[] sosuCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        inputList = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputList[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, inputList[i]);
        }

        findSosu(max);
        sosuCnt = new int[sosuList.size()];
        for (int x : inputList) {
            for (int i = 0; i < sosuList.size(); i++) {
                if (x % sosuList.get(i) == 0) {
                    while (x % sosuList.get(i) == 0) {
                        sosuCnt[i]++;
                        x /= sosuList.get(i);
                    }
                }
                if (x == 1)
                    break;
            }
        }

        int maxResult = 1;
        for (int i = 0; i < sosuCnt.length; i++) {
            sosuCnt[i] /= N;
            if (sosuCnt[i]>0)
                maxResult *= pow(sosuList.get(i), sosuCnt[i]);
        }

        int calcCnt = 0;
        // 각 sosuCnt에서 0이상의 값을 요구하는 값을 가지고 있거나 가지고있지 않을 때, 연산수 추가
        for (int x : inputList) {
            for (int i = 0; i < sosuCnt.length; i++) {
                if (sosuCnt[i]>0) {
                    // 몫이 존재한다면, 부족한 만큼만 추가. 넘치면 추가하지 않음
                    if (x % sosuList.get(i) == 0) {
                        int cnt = 0;
                        while (x % sosuList.get(i) == 0) {
                            cnt++;
                            x /= sosuList.get(i);
                        }
                        if (cnt < sosuCnt[i])
                            calcCnt += sosuCnt[i] - cnt;
                    }
                    // 몫이 존재하지 않는다면 sosuCnt 값을 추가
                    else
                        calcCnt += sosuCnt[i];
                }
            }
        }

        System.out.println(maxResult+" "+calcCnt);

    }

    static int pow(int base, int exp) {
        int res = 1;
        for (int i = 1; i <= exp; i++) {
            res *= base;
        }
        return res;
    }

    static void findSosu(int max) {
        boolean[] isntSosu = new boolean[max+1]; // 0번 index 미사용, 초기화 값이 false임
        for (int i = 2; i < Math.pow(max, 0.5)+1; i++) {
            if (!isntSosu[i]) {
                //sosuList.add(i);
                for (int j = i*i; j < max+1; j += i)
                    isntSosu[j] = true;
            }
        }
        for (int i = 2; i <= max; i++)
            if (!isntSosu[i]) sosuList.add(i);
    }
}