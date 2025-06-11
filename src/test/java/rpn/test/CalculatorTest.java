package rpn.test;

import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    /**
     * Проверка сложения
     * Действия: Создать массив ["2", "3", "+"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 5;
     */
    @Test
    void testAddition() {
        String[] input = {"2", "3", "+"};
        int result = Calculator.evaluate(input);
        assertThat(result).isEqualTo(5);
    }

    /**
     * Проверка вычитания
     * Действия: Создать массив ["5", "3", "-"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 2;
     */
    @Test
    void testSubtraction() {
        String[] input = {"5", "3", "-"};
        int result = Calculator.evaluate(input);
        assertThat(result).isEqualTo(2);
    }

    /**
     * Проверка умножения
     * Действия: Создать массив ["2", "3", "*"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 6;
     */
    @Test
    void testMultiplication() {
        String[] input = {"2", "3", "*"};
        int result = Calculator.evaluate(input);
        assertThat(result).isEqualTo(6);
    }

    /**
     * Проверка деления
     * Действия: Создать массив ["6", "3", "/"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 2;
     */
    @Test
    void testDivision() {
        String[] input = {"6", "3", "/"};
        int result = Calculator.evaluate(input);
        assertThat(result).isEqualTo(2);
    }

    /**
     * Проверка сложного выражения
     * Действия: Создать массив ["4", "15", "5", "/", "+"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 3: (4 + (15 / 5) ) = 4 + 3 = 7;
     */
    @Test
    void testComplexExpression() {
        String[] input = {"4", "15", "5", "/", "+"};
        int result = Calculator.evaluate(input);
        assertThat(result).isEqualTo(7);
    }

    /**
     * Проверка деления на ноль
     * Действия: Создать массив ["4", "0", "/"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() выбросит ArithmeticException;
     */
    @Test
    void testDivisionByZero() {
        String[] input = {"4", "0", "/"};
        assertThatThrownBy(() -> Calculator.evaluate(input))
                .isInstanceOf(ArithmeticException.class);
    }

    /**
     * Проверка недопустимого оператора
     * Действия: Создать массив ["4", "2", "^"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() выбросит IllegalArgumentException;
     */
    @Test
    void testInvalidOperator() {
        String[] input = {"4", "2", "^"};
        assertThatThrownBy(() -> Calculator.evaluate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка недостатка операндов
     * Действия: Создать массив ["4", "+"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() выбросит IllegalArgumentException;
     */
    @Test
    void testNotEnoughOperands() {
        String[] input = {"4", "+"};
        assertThatThrownBy(() -> Calculator.evaluate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка пустого ввода
     * Действия: Создать пустой массив []; вызвать evaluate();
     * Ожидаемый результат: evaluate() выбросит IllegalArgumentException;
     */
    @Test
    void testEmptyInput() {
        String[] input = {};
        assertThatThrownBy(() -> Calculator.evaluate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка лишних чисел в стеке
     * Действия: Создать массив ["1", "2", "3", "+"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() выбросит IllegalArgumentException;
     */
    @Test
    void testExtraNumbers() {
        String[] input = {"1", "2", "3", "+"};
        assertThatThrownBy(() -> Calculator.evaluate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверка выражения из одного числа
     * Действия: Создать массив ["1"]; вызвать evaluate();
     * Ожидаемый результат: evaluate() вернет 1;
     */
    @Test
    void testSoloNumber() {
        String[] input = {"1"};
        assertThat(Calculator.evaluate(input)).isEqualTo(1);
    }
}