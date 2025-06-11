package org.example;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Arrays;

//import java.util.*;

public class Transformer {

    // Приоритеты операторов
    private static int getPrecedence(String op) {
        return switch (op) {
            case "+", "-" -> 3;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String[] toReversePolishNotation(String input) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        String[] tokens = input.split(" ");

        for (String token : tokens) {
            // Если число
            if (token.matches("-?\\d+")) {
                output.add(token);
                // Если оператор
            } else if (token.matches("[+\\-*/]")) {
                // Выталкиваем из стека операторы с более высоким или равным приоритетом
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else {
                throw new IllegalArgumentException("Недопустимый токен: " + token);
            }
        }

        // Выталкиваем остальные операторы
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output.toArray(new String[0]);
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(Transformer.toReversePolishNotation("1 + 2 - 11 * 2")));
        // ["1", "2", "+"]
        System.out.println(Calculator.evaluate(Transformer.toReversePolishNotation("1 + 2 - 11 * 2")));

        System.out.println(Arrays.toString(Transformer.toReversePolishNotation("3 * 4 + 5")));
        // ["3", "4", "*", "5", "+"]
        System.out.println(Calculator.evaluate(Transformer.toReversePolishNotation("3 * 4 + 5")));

        System.out.println(Arrays.toString(Transformer.toReversePolishNotation("10 - 2 / 2")));
        // ["10", "2", "2", "/", "-"]
        System.out.println(Calculator.evaluate(Transformer.toReversePolishNotation("10 - 2 / 2")));

        String input = "";
        System.out.println(Calculator.evaluate(Transformer.toReversePolishNotation(input)));

    }
}