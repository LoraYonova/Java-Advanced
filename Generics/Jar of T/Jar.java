package Generics.Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T elements) {
        this.elements.push(elements);
    }

    public T remove() {
        return this.elements.pop();
    }
}
