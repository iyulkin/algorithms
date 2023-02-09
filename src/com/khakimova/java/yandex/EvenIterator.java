package com.khakimova.java.yandex;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Написать реализацию четного итератора.
 * - метод boolean hasNext() должен возвращать true, если имеется следующее четное число в коллекции
 * - метод next() должен возвращать очередное четное число коллекции, если оно есть. В противном случае генерировать исключение NoSuchElementException
 */
public class EvenIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 4, 5, 6, 7, 8, 9);
        EvenIterator evenIterator = new EvenIterator(list.iterator());
        assertTrue(evenIterator.hasNext());
        assertTrue(evenIterator.hasNext());
        assertEquals(4, evenIterator.next());
        assertEquals(6, evenIterator.next());
        assertEquals(8, evenIterator.next());
        assertFalse(evenIterator.hasNext());
        assertThrows(NoSuchElementException.class, evenIterator::next);
    }

    private Iterator<Integer> iterator;
    private Integer next;

    public EvenIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        while (next == null && iterator.hasNext()) {
            next = iterator.next();
            if (next % 2 == 0) {
                return true;
            } else {
                next = null;
            }
        }
        return next != null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = next;
            next = null;
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }
}
