package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.<Integer>create(10, 13);

        String[] strings = ArrayCreator.<String>create(String.class, 3, "Java");


    }
}
