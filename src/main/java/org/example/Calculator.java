package org.example;

import java.util.Stack;

public class Calculator {
    public static int evaluate(String[] tokens) {
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            // Если это операнд
            if (!operators.contains(t)) {
                stack.push(Integer.valueOf(t));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Недостаточно операндов для операции");
                }
                int a = stack.pop();
                int b = stack.pop();
                stack.push(applyOperator(a, b, t));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("В стеке не осталось элементов после вычисления");
        }
        return stack.pop();
    }

    private static int applyOperator(int a, int b, String t) {
        switch (t) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                if (a == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return b / a;
            default:
                throw new IllegalArgumentException("Неверный оператор");
        }
    }
}
