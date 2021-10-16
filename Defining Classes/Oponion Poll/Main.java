package DefiningClassesOpinionPoll;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<OpinionPoll> people = new ArrayList<>();
        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            if (Integer.parseInt(input[1]) > 30) {
            OpinionPoll opinionPoll = new OpinionPoll(input[0], Integer.parseInt(input[1]));

            people.add(opinionPoll);
            }


        }
        people.sort(Comparator.comparing(OpinionPoll::getName));
        people.forEach(System.out::println);

    }
}

