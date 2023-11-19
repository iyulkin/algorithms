package interview2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Необходимо реализовать аналог enum:
 * - Добавление новых элементов в перечисление должно быть простым и понятным
 * - Необходимо иметь доступ к элементам перечисления через "."
 * - Должна быть возможность безопасного сравнения элементов перечисления с помощью "=="
 * - Реализовать метод получения всех элементов перечисления values()
 * - Реализовать метод получения элемента перечисления по порядковому номеру ordinal
 */
public class EnumRealization {

    public static void main(String[] args) {
        List<CurrencyEnum> currencyValues = CurrencyEnum.values();
        assertEquals(2, currencyValues.size());
        assertTrue(currencyValues.contains(CurrencyEnum.RUB));
        assertTrue(currencyValues.contains(CurrencyEnum.USD));
        assertTrue(CurrencyEnum.RUB == CurrencyEnum.RUB);
        assertEquals(CurrencyEnum.RUB, CurrencyEnum.get(0));
    }

    static class CurrencyEnum {
        private int value;
        private static final List<CurrencyEnum> values = new ArrayList<>();

        public static final CurrencyEnum USD = new CurrencyEnum();
        public static final CurrencyEnum RUB = new CurrencyEnum();

        private CurrencyEnum() {
            this.value = CurrencyEnum.values.size();
            CurrencyEnum.values.add(this);
        }

        public static List<CurrencyEnum> values() {
            return Collections.unmodifiableList(CurrencyEnum.values());
        }

        public static CurrencyEnum get(int ordinal) {
            if (ordinal >= CurrencyEnum.values().size()) {
                throw new NoSuchElementException();
            }
            return CurrencyEnum.values().get(ordinal);
        }
    }
}
