package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CustomList<T extends Comparable<T>> implements Iterable<T> {


    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }


    public void add(T element) {

        this.elements.add(element);
    }

    public T getMax() {
        ensureIndex(elements);
        return Collections.max(elements);

    }

    public T getMin() {
        ensureIndex(elements);
        return Collections.min(elements);
    }


    public int countGreaterThan(T element) {
        return (int) elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public void swap(int firstIndex, int secondIndex) {
        if (checkIndex(firstIndex, secondIndex, elements.size())) {

            T first = elements.get(firstIndex);
            T second = elements.get(secondIndex);
            elements.set(firstIndex, second);
            elements.set(secondIndex, first);
        }
    }

    private boolean checkIndex(int firstIndex, int secondIndex, int size) {
        return firstIndex >= 0 && firstIndex < size && secondIndex >= 0 && secondIndex < size;

    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    private static <T> void ensureIndex(List<T> elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}