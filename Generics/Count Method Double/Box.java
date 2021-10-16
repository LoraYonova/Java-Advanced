package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable <T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T fist = elements.get(firstIndex);
        T second = elements.get(secondIndex);
        elements.set(firstIndex, second);
        elements.set(secondIndex,fist);
    }
   public int greaterCountOfElement(T valueOfElement) {
        return (int) this.elements.stream().filter(e -> e.compareTo(valueOfElement) > 0).count();
   }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : elements) {
            builder.append(String.format("%s: %s", element.getClass().getName(), element));
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

}
