import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else { // c == ')'
                stack.pop();
                // () 모양 : 레이저
                if (input.charAt(i - 1) == '(') {
                    // 쌓여있는 만큼 조각 발생함 (레이저 기준 왼쪽부분들)
                    result += stack.size();
                    // 잘린부분의 오른쪽은 이하에서 처리
                }
                else {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }
}