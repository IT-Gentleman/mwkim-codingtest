import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // top이 커서 위치임
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            leftStack.push(input.charAt(i));
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            char command = scanner.next().charAt(0);
            switch (command) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(scanner.next().charAt(0));
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : leftStack) {
            result.append(ch);
        }
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.print(result);

    }
}