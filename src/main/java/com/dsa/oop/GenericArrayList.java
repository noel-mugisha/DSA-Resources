package com.dsa.oop;

public class GenericArrayList<T> {

    private Object[] elements;
    private int size;

    public GenericArrayList() {
        elements = new Object[1];
        size = 0;
    }

    public void add(T value) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // we set it to null for memory management
        elements[size - 1] = null;
        size--;

        return removed;
    }

    public void removeLast() {
        if (size == 0) return;
        // we set it to null for memory management
        elements[size - 1] = null;
        size--;
    }

    public void insert(int index, T value) {
        // we do not do index >= size because we can insert a new element at the end
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == elements.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = value;
        size++;
    }

    public boolean contains(T value) {

        for (int i = 0; i < size; i++) {

            if (elements[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // we set it to null for memory management
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArr = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        elements = newArr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {

            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}