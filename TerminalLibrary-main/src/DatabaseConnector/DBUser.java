package DatabaseConnector;


import Objective.User;
import Objective.Student;


import java.sql.SQLException;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.ResultSet;

public class DBUser extends DatabaseConnector {
    
    public static User getUserInfo(User in)throws SQLException {
        if (in.getRight() == User.SET_STUDENT) {
            ResultSet rs;
            Student found;
        
            CallableStatement finder = (CallableStatement) connection.prepareCall("{ call findStudent(?) }");
        
            finder.setString(1, in.getID());
        
            rs = finder.executeQuery();
        
            while (rs.next()) {
                found = new Student(in.getID(), rs.getString("userName"), rs.getString("dateOfBirth"), rs.getString("contact"), rs.getString("classID"), rs.getInt("age"));
                return found;
            }
        
            return null;
        }
        
        return null;
    }
    
    public static void changeUserName(String userID, String newUserName) throws SQLException {
        CallableStatement finder = (CallableStatement) connection.prepareCall("{ call changeUserName(?, ?) }");
        
        finder.setString(1, userID);
        finder.setString(2, newUserName);
        
        finder.executeQuery();
    }
    
    public static void changeContact(String userID, String newContact) throws SQLException {
        CallableStatement finder = (CallableStatement) connection.prepareCall("{ call changeContact(?, ?) }");
        
        finder.setString(1, userID);
        finder.setString(2, newContact);
        
        finder.executeQuery();
    }

}
