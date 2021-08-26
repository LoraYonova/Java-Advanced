package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);

            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char ch = stack.pop();
                if (ch == '(' && symbol == ')') {
                    isBalanced = true;
                } else if (ch == '{' && symbol == '}') {
                    isBalanced = true;
                } else if (ch == '[' && symbol == ']') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }


        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
