package com.skypro.integerlist;

import com.skypro.integerlist.exception.*;

import java.util.Arrays;


public class IntegerService implements IntegerList {

    private final Integer[] integers;

    private int size;

    public IntegerService(int size) {
        this.integers = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new InCorrectElementException("Введите данные");
        }
        if (size >= integers.length) {
            throw new FullListException("Массив заполнен.");
        }
        integers[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= integers.length || index > size) {
            throw new ExceedsLengthException("Больше допустимых значений.");
        }
        if (size == integers.length) {
            throw new FullListException("Массив заполнен.");
        }
        integers[index] = item;
        return integers[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index > integers.length || index > size) {
            throw new ExceedsLengthException("Больше допустимых значений.");
        }
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new InCorrectElementException("Введите данные.");
        }
        if (indexOf(item) == -1) {
            throw new NotElementException("Элемент не найден.");
        }
        if (indexOf(item) != size) {
            System.arraycopy(integers, indexOf(item) + 1, integers, indexOf(item), size - indexOf(item));
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer item = integers[size];
        if (index == 0) {
            throw new InCorrectElementException("Вы ввели пустую строку");
        }
        if (index == -1) {
            throw new NotElementException("Элемент не найден");
        }
        if (index != size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        if (binarySearch(integers, item) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= integers.length || index > size) {
            throw new ExceedsLengthException("Больше допустимых значений.");
        }
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new EmptyListException("Массив не заполнен");
        }
        if (this.size == otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!integers[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return integers[0] == null;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    private static void swapElements(Integer[] integers, int index1, int index2) {
        int tmp = integers[index1];
        integers[index1] = integers[index2];
        integers[index2] = tmp;
    }

//    public void sortBubble(Integer[] integers) {
//        for (int i = 0; i < integers.length - 1; i++) {
//            for (int j = 0; j < integers.length - 1 - i; j++) {
//                if (integers[j] > integers[j + 1]) {
//                    swapElements(integers, j, j + 1);
//                }
//            }
//        }
//    }

    @Override
    public void passingSorting(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }

//    public void sortInsertion(Integer[] integers) {
//        for (int i = 1; i < integers.length; i++) {
//            int temp = integers[i];
//            int j = i;
//            while (j > 0 && integers[j - 1] >= temp) {
//                integers[j] = integers[j - 1];
//                j--;
//            }
//            integers[j] = temp;
//        }
//    }

    private static int binarySearch(Integer[] integers, Integer item) {
        int left = 0;
        int right = integers.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int current = integers[middle];
            if (current == item) {
                return middle;
            } else if (current < item) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
