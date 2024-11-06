package Objective;


import java.sql.SQLException;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;


import DatabaseConnector.DBRequest;
import DatabaseConnector.DBUser;
import DatabaseConnector.DBLogin;

public class User {
    public final static int SET_STUDENT = 0;
    public final static int SET_ADMIN = 1;
    public final static int SET_AUTHOR = 2;
    
    protected String ID;
    protected int right = SET_STUDENT;
    
    
    
    public User(){}

    public User(String userID) {
        this.ID = userID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String userID) {
        this.ID = userID;
    }

    public int getRight() {
        return right;
    }

    private void setRight(int right) {
        this.right = right;
    }
    
    @Override
    public String toString() {
        return "User " + ID;
    }
    
    /**
     * Log in into the account you put.
     * <h2>If first LogIn situation, you must repair this method.<h2>
     * 
     * @param ID = userID to log in (mostly studentID).
     * @param password = password.
     * 
     * @return true if correct.
     * 
     * @throws SQLException 
     */
    public boolean logIn(String ID, String password) throws SQLException {
        switch (DBLogin.logIn(ID, password)) {
            case DBLogin.TRUE_LOG_IN -> {
                this.setID(ID);
                // If you are admin or author, there must be more details.
                return true;
            }
            case DBLogin.FIRST_LOG_IN -> {
                System.out.println("This is your first time LogIn.\nPlease enter your new Password.");
                Scanner sc = new Scanner(System.in);
                
                String newP = sc.nextLine();
                
                if (DBLogin.firstLogIn(ID, newP) == DBLogin.TRUE_LOG_IN) {
                    this.setID(ID);
                    // If you are admin or author, there must be more details.
                    return true;
                }
                else return false;
            }
            case DBLogin.FAIL_LOG_IN -> {
                return false;
            }

        }
        return false;
    }
    
    
    /**
     * Get full detail information of this user. Whatever the right
     * With toString been Override too.
     * 
     * @return another var contain full information for this.
     * 
     * @throws SQLException 
     */
    public User getInfo() throws SQLException {
        return DBUser.getUserInfo(this);
    }
    
    public void changeUserName(String newUserName) throws SQLException {
        DBUser.changeUserName(this.ID, newUserName);
    }
    
    public void changeContact(String newContact) throws SQLException {
        DBUser.changeUserName(this.ID, newContact);
    }
    
    public boolean changePassword(String oldPassword, String newPassword) throws SQLException {
        return DBLogin.changePassword(this.ID, oldPassword, newPassword) == DBLogin.TRUE_LOG_IN;
    }
    
    /**
     * Borrow the book determine by bookID.
     * 
     * @param bookID = ID of the book
     * @param quantity = quantity you want to borrow.
     * 
     * @return if the book not Out of Stock, then true.
     * 
     * @throws SQLException 
     */
    public boolean borrowBook(String bookID, int quantity) throws SQLException, IOException, Exception {
        return DBRequest.borrowBook(this.ID, bookID, quantity);
    }
    
    
    /**
     * Apply a return quest determine by requestID receive when you borrow
     * 
     * @param requestID = ID of the request.
     * 
     * @return true if the return done.
     * 
     * @throws SQLException 
     */
    public boolean returnBook (Request thisRequest) throws SQLException {
        return DBRequest.returnBook(thisRequest);
    }
    
    
    /**
     * Get your Un-returned Books List.
     * 
     * @return An ArrayList of request.
     * 
     * @throws SQLException 
     */
    public ArrayList<Request> getMyUnreturnBook() throws SQLException {
        return DBRequest.UnreturnBookList(this.ID);
    }
    
    
    /**
     * Get your full history of ever borrowed Books List.
     * 
     * @return An ArrayList of request.
     * 
     * @throws SQLException 
     */
    public ArrayList<Request> getMyHistory() throws SQLException {
        return DBRequest.everBorrowBookList(this.ID);
    }
}
