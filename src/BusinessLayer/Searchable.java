package BusinessLayer;

public interface Searchable {
    public boolean searchByTitle(String title);
    public boolean searchByTitleAndType(String title, String type);
}