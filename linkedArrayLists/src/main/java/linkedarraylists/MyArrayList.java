package linkedarraylists;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] data;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public T get(int index) {
        isLargerThanSize(index);
        return (T) data[index];
    }

    private void isLargerThanSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(T element) {
        data[size] = element;
        size++;

        if (isFull()) {
            resize();
        }
    }

    private boolean isFull() {
        return (data.length == size);
    }

    private void resize() {
        Object[] dataTwo = new Object[data.length * 2];
        System.arraycopy(data, 0, dataTwo, 0, data.length);
        data = dataTwo;
    }

    @Override
    public void remove(int index) {
        isLargerThanSize(index);
        while (data[index] != null) {
            data[index] = data[index + 1];
            index++;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(data).filter(Objects::nonNull).toArray());
    }
}
