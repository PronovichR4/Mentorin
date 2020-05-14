package by.epam.pronovich.homework01.task02;

import java.util.Arrays;

public class DynamicArray<T> {

    private int initialCapacity;
    private T[] array;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.array = (T[]) new Object[initialCapacity];
    }

    public void add(T value) {
        T[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = value;
        array = newArray;
    }

    public T get(int index) {
        return array[index];
    }

    public void remove(int index) {
        T[] newArray = (T[]) new Object[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {

            if (i == index) {
                continue;
            }
            newArray[j] = array[i];
            j++;
        }
        array = newArray;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
