package FirstRunExample;


import java.io.File;

import DatabaseConnector.UpdateFile;
import DatabaseConnector.DatabaseConnector;
import java.io.IOException;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {
    public static void main(String[] args) {
        
        // Setup something may need. Just skip this.
        try {
            DatabaseConnector.firstTODO();
        } catch (SQLException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Can't connect to DATABASE");
        }
        
        
        /**
         * Upload file trong folder 'Example Data' vào database. 
         * Yêu cầu 1 là đã tạo database như readme trong Query SQL
         * Yêu cầu 2 là bật XAMPP nếu có, tu chỉnh code trong DatabaseConnector.DatabaseConnector trong method getJDBCConnector.
         * 
         * Chỉ cần có file pdf trong Example Data, rồi nạp tên vào như mẫu là được. Nạp xong có thể kiểm tra trực tiếp trong workbench.
         */
        try {
            File temp = new File("Example Data/Phát triển ứng dụng quản lý thư viện bằng Java.pdf");
        
            if (UpdateFile.uploadBookFileToDatabase("B000", temp)) {
                System.out.println("Upload done");
            }
            
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("1. Can't upload File to DATABASE");
        } catch (Exception ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("2. Can't upload File to DATABASE");
            
        } finally {
            DatabaseConnector.closeConnection();
        }
    }
}
