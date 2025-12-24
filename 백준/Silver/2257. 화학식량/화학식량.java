import java.io.*;
import java.util.*;

public class Main {

    static class StackClass {
        static int[] HCOValue = {1, 12, 16};
        int totalValue = 0;
        int lastValue;
        void addValue(char input) {
            switch (input) {
                case 'H':
                    totalValue += HCOValue[0];
                    lastValue = HCOValue[0];
                    break;
                case 'C':
                    totalValue += HCOValue[1];
                    lastValue = HCOValue[1];
                    break;
                case 'O':
                    totalValue += HCOValue[2];
                    lastValue = HCOValue[2];
                    break;
            }
        }
        void multiplyLast(int multiplier) {
            totalValue += lastValue * (multiplier-1);
            // -1 을 하는 이유는, 직전에 하나 더해짐
        }
        void addHCO(int totalValue) {
            this.totalValue += totalValue;
            lastValue = totalValue;
        }
    }

    static Stack<StackClass> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        //st = new StringTokenizer(br.readLine());
        char[] input = br.readLine().toCharArray();
        stack.push(new StackClass());
        for (char c : input) {
            if (c=='(') {
                stack.push(new StackClass());
            } else if (c==')') {
                StackClass top = stack.pop();
                stack.peek().addHCO(top.totalValue);
            } else if ("HCO".indexOf(c) != -1) {
                stack.peek().addValue(c);
            } else {
                stack.peek().multiplyLast(c-'0');
            }
        }
        System.out.println(stack.peek().totalValue);
    }
}