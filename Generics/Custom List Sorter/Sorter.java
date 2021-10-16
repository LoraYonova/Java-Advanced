package CustomList;


public class Sorter {

    public static void sort(CustomList customList) {
        int size = customList.getElements().size();
        for (int i = 0; i < size; i++) {
            String element = (String) customList.getElements().get(i);
            for (int j = i + 1; j < size; j++) {
                String nextElement = (String) customList.getElements().get(j);
                if (element.compareTo(nextElement) > 0) {
                    customList.swap(i, j);
                }
            }
        }

    }


}
