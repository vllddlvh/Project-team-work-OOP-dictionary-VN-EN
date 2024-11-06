package Objective;

import java.sql.SQLException;
import java.util.ArrayList;



public class Book {
    protected String id;
    protected String name;
    protected String author;
    protected String category;
    protected int quantity;
    
    public Book() {}
    
    public Book(String id, String name, String author, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    public String getBookId() {
        return id;
    }

    public void setBookId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n\tname = " + name + "\n\tauthor = " + author + "\n\tcategory = " + category + "\n\tquantity = " + quantity + '\n';
    }
    
    /**
     * <p>
     * findBy option:<br>
     *     1. find by name<br>
     *     2. find by category<br>
     *     3. find by author<br>
     *     4. find by publisher<br>
     * <p>
     * <p>
     * sortBy option:<br>
     *      0. sort by insert index (else)<br>
	 *      1. sort by book's name ASC<br>
     *      2. sort by book's name DESC<br>
     *      3. sort by releaseDate ASC<br>
     *      4. sort by releaseDate DESC
     * <p>
     * 
     * @param keyword = words you need to find in the title.
     * @param searchBy = the type you want to search.
     * @param sortBy = the way of sort you want.
     * 
     * @return detail of all the books be founded.
     */
    public static ArrayList<Book> findBook(String keyword, int searchBy, int sortBy) throws SQLException {
        ArrayList<Book> found = DBBook.findBook(keyword, searchBy, sortBy);
        
        return found;
    } 
    
    public void oneTimeOpenBook() {
        UpdateFile.oneTimeOpenBook(this.id);
    }
}
