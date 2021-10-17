import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {
        int compared = s.getTitle().compareTo(f.getTitle());
        if (compared == 0) {
            compared = Integer.compare(f.getYear(), s.getYear());
        }
        return compared;
    }
}
