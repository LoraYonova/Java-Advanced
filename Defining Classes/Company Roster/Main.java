package DefiningClassesCompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Department> department = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        Employee employee = null;

        while (n-- > 0) {

            String dataEmployees = scan.nextLine();

            String[] tokens = dataEmployees.split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departments = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, departments, email, age);

            } else if (tokens.length == 5) {
                String parameter = tokens[4];
              try {
                  int age = Integer.parseInt(parameter);
                  employee = new Employee(name, salary, position, departments, age);
              } catch (NumberFormatException e) {
                  String email = parameter;
                  employee = new Employee(name, salary, position, departments, email);
              }


            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, departments);

            }

            if (!department.containsKey(departments)) {
                department.put(departments, new Department(departments));
            }
                department.get(departments).getEmployees().add(employee);



        }

        Department maxAverageSalary = department.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalary.getName());
        maxAverageSalary.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
