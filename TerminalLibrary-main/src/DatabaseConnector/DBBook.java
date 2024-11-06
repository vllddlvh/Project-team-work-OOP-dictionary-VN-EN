package DatabaseConnector;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.CallableStatement;


import Objective.Book;
import java.util.ArrayList;

public class DBBook extends DatabaseConnector {
    
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
     * @return an ArrayList<Book> of what you need.
     * 
     * @throws SQLException 
     */
    public static ArrayList<Book> findBook(String keyword, int searchBy, int sortBy) throws SQLException {
        ResultSet rs;
        ArrayList<Book> found = new ArrayList<>();
        
        CallableStatement finder = (CallableStatement) connection.prepareCall("{ call findBook(?, ?, ?) }");
        
        finder.setString(1, keyword);
        finder.setString(2, String.valueOf(searchBy));
        finder.setString(3, String.valueOf(sortBy));
        
        rs = finder.executeQuery();
        
        while(rs.next()) {
            found.add(new Book(rs.getString("bookID"), rs.getString("b_name"), rs.getString("author"), rs.getString("category"), rs.getInt("quantityLeft")));
        }
        return found;
    }
    
    public static Book findBook(String bookID) throws SQLException {
        ResultSet rs;
        Book found;
        
        CallableStatement finder = (CallableStatement) connection.prepareCall("{ call findBookFromID(?) }");
        
        finder.setString(1, bookID);
        
        rs = finder.executeQuery();
        
        while (rs.next()) {
            found = new Book(bookID, rs.getString("b_name"), rs.getString("author"), rs.getString("category"), rs.getInt("quantityLeft"));
            return found;
        }
        
        return null;
    }
}
