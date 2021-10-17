package listyIterator;

import java.util.Arrays;

import java.util.List;

public class ListyIterator {
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
    }



