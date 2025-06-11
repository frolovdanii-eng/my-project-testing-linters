package rpn.test;

import org.example.Transformer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TransformerTest {
    /**
     * Проверка простого сложения
     * Действия: Преобразовать строку "1 + 2"
     * Ожидаемый результат: Массив ["1", "2", "+"]
     */
    @Test
    void testSimpleAddition() {
        String input = "1 + 2";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("1", "2", "+");
    }

    /**
     * Проверка приоритета операторов
     * Действия: Преобразовать строку "1 + 2 * 3"
     * Ожидаемый результат: Массив ["1", "2", "3", "*", "+"]
     */
    @Test
    void testOperatorPrecedence() {
        String input = "1 + 2 * 3";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("1", "2", "3", "*", "+");
    }

    /**
     * Проверка одинакового приоритета операторов
     * Действия: Преобразовать строку "1 + 2 - 3"
     * Ожидаемый результат: Массив ["1", "2", "+", "3", "-"]
     */
    @Test
    void testSamePrecedence() {
        String input = "1 + 2 - 3";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("1", "2", "+", "3", "-");
    }

    /**
     * Проверка сложного выражения
     * Действия: Преобразовать строку "3 * 4 + 5 / 2 - 1"
     * Ожидаемый результат: Массив ["3", "4", "*", "5", "2", "/", "+", "1", "-"]
     */
    @Test
    void testComplexExpression() {
        String input = "3 * 4 + 5 / 2 - 1";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("3", "4", "*", "5", "2", "/", "+", "1", "-");
    }

    /**
     * Проверка отрицательных чисел
     * Действия: Преобразовать строку "-1 + 2"
     * Ожидаемый результат: Массив ["-1", "2", "+"]
     */
    @Test
    void testNegativeNumbers() {
        String input = "-1 + 2";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("-1", "2", "+");
    }

    /**
     * Проверка на недопустимый токен
     * Действия: Преобразовать строку "1 & 2"
     * Ожидаемый результат: IllegalArgumentException
     */
    @Test
    void testInvalidToken() {
        String input = "1 & 2";
        assertThatThrownBy(() -> Transformer.toReversePolishNotation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка пустой строки
     * Действия: Преобразовать пустую строку ""
     * Ожидаемый результат: Пустой массив []
     */
    @Test
    void testEmptyString() {
        String input = "";
        assertThatThrownBy(() -> Transformer.toReversePolishNotation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка строки с одним числом
     * Действия: Преобразовать строку "42"
     * Ожидаемый результат: Массив ["42"]
     */
    @Test
    void testSingleNumber() {
        String input = "42";
        String[] result = Transformer.toReversePolishNotation(input);
        assertThat(result).containsExactly("42");
    }
}