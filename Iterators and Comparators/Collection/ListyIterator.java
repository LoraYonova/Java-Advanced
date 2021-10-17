package listyIterator;

import javax.swing.*;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> element;
    private int index;

    public ListyIterator(String... element) {
        this.element = Arrays.asList(element);
        index = 0;
    }

    public boolean hasNext() {
        return index < element.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.element.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.element.get(index));
        }

        public void printAll() {
        this.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < element.size();
            }

            @Override
            public String next() {
                String elements = element.get(index);
                index++;
                return elements;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.element.forEach(action::accept);
    }
}



