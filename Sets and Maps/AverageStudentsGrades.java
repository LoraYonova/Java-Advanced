package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

       while (n-- > 0) {
           String[] input = scan.nextLine().split("\\s+");
           String name = input[0];
           double grades = Double.parseDouble(input[1]);

           if (!students.containsKey(name)) {
               students.put(name, new ArrayList<>());

           }
           students.get(name).add(grades);

       }


       students.entrySet()
                .forEach(entry -> {
                    double sumGrades = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sumGrades += entry.getValue().get(i);
                    }

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", sumGrades / entry.getValue().size());
                });



    }
}
