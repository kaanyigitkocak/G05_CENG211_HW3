package BusinessLayer;

public interface Searchable {
    boolean searchByTitle(String title);
    boolean searchByTitleAndType(String title, String type);
}