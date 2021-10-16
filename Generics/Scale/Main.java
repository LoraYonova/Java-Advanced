package GenericScale;

public class Main {
    public static void main(String[] args) {

        System.out.println(new Scale<>(13, 42).getHeavier());
        System.out.println(new Scale<>("A", "Z").getHeavier());
        System.out.println(new Scale<>(13.5, 14.5).getHeavier());
        System.out.println(new Scale<>(13, 42).getHeavier());




    }
}
