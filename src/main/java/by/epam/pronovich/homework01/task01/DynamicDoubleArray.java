package by.epam.pronovich.homework01.task01;

import java.util.Arrays;

public class DynamicDoubleArray {

    private int initialCapacity;
    private double[] array;

    public double[] getArray() {
        return array;
    }

    public DynamicDoubleArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.array = new double[initialCapacity];
    }

    public void add(double value) {
        double[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = value;
        array = newArray;
    }


    public double get(int index) {
        return array[index];
    }

    public void remove(int index) {
        double[] newArray = new double[array.length - 1];
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
        return "DynamicDoubleArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
