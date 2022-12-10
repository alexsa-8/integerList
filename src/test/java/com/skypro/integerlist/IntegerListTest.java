package com.skypro.integerlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {
    private IntegerService integerService;
    private final static Integer TEST1 = 15;
    private final static Integer TEST2 = 30;
    private final static Integer TEST3 = 45;
    private final static Integer TEST4 = 60;
    private final static int INDEX = 1;

    @BeforeEach
    public void setUp() {
        integerService = new IntegerService(4);
        integerService.add(TEST1);
        integerService.add(TEST2);
    }

    @Test
    void add() {
        assertSame(integerService.add(TEST1), TEST1);
    }

    @Test
    void testAdd() {
        assertEquals(integerService.add(INDEX, TEST2), TEST2);
    }

    @Test
    void set() {
        assertEquals(integerService.set(INDEX, TEST3), TEST3);
    }

    @Test
    void remove() {
        assertEquals(integerService.remove(TEST1), TEST1);
    }

    @Test
    void testRemove() {
        integerService.remove(INDEX);
    }

    @Test
    void containsTrue() {
        integerService.add(TEST4);
        assertTrue(integerService.contains(TEST4));
    }

    @Test
    void containsFalse() {
        assertFalse(integerService.contains(0));
    }

    @Test
    void indexOf() {
        assertEquals(1, integerService.indexOf(TEST2));
    }

    @Test
    void lastIndexOf() {
        assertEquals(1, integerService.lastIndexOf(TEST2));
    }

    @Test
    void get() {
        assertEquals(TEST2, integerService.get(INDEX));
    }

    @Test
    void testEquals() {
        IntegerService list = new IntegerService(4);
        list.add(TEST3);
        list.add(TEST4);
        assertFalse(integerService.equals(list));
    }

    @Test
    void size() {
        assertEquals(2, integerService.size());
    }

    @Test
    void isEmpty() {
        assertFalse(integerService.isEmpty());
    }

    @Test
    void clear() {
        integerService.clear();
        assertEquals(0, integerService.size());
    }

    @Test
    void toArray() {
        Integer[] test = new Integer[]{TEST1, TEST2};
        assertArrayEquals(test, integerService.toArray());
    }

    @Test
    void passingSorting() {
        Integer[] list = {TEST1, TEST2, TEST3, TEST4};
        integerService.passingSorting(list);
    }
}