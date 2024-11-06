package test;


import Objective.Student;
import Objective.Request;
import Objective.Book;

import java.util.Scanner;
import java.util.ArrayList;

import java.sql.SQLException;
import java.io.IOException;



public class ConsoleInterface {
    private final static Scanner sc = new Scanner(System.in);
    public static Student currentUser = new Student();
    
    public final static int EXIT = -1;
    public final static int BACKWARD = -2;
    public final static int RE_RUN = -3;
    
    /**
     * Keep it clear and simple.
     * When I call an option list, only return 'true' == backward.
     * If return 'false', program shutdown.
     * Cause the task done, or user exit. 
     */

     public static void main(String[] args) {
         
        try {

            int temp = RE_RUN;
            while (temp == RE_RUN) {
                temp = logInMenu();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace(); 
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\nCannot connect to Database");
        }
        catch (Exception ex) {
            ex.printStackTrace(); 
        }
        finally {
            // Close things in the end.
            sc.close();
        }
    }
    
    public static void clearConsole() {
        for (int i = 0; i < 20; i++) System.out.println();
    }
   
    public static int logInMenu() throws SQLException, IOException, Exception {
        String temp;
        clearConsole();
        
        System.out.println("Press only Enter to EXIT anytime.");
        System.out.print ("Username: ");
        temp = sc.nextLine();
        if (temp.equals("")) {
            return EXIT;
        } else {
            currentUser.setID(temp);
        }
        
        System.out.print ("Password: ");
        temp = sc.nextLine();
        if (temp.equals("")){
            return EXIT;
        }
        
        int tp = RE_RUN;
        if (currentUser.logIn(currentUser.getID(), temp)) {
            while (tp == RE_RUN) {
                tp = mainMenu();
            }
            if (tp == EXIT) return EXIT;
            else return RE_RUN;
            
        }
        
        clearConsole();
        System.out.println("WRONG PASSWORD. PLEASE TRY AGAIN.");
        return RE_RUN; // keeping loop
    }
    
    
    public static int mainMenu() throws SQLException, IOException, Exception {
        clearConsole();
        
        System.out.println("What do you wanna do?\n");
        
        System.out.println("[1] Find book");
        System.out.println("[2] Return book");
        System.out.println("[3] Operate as author right");
        System.out.println("[4] User setting");
        System.out.println("[0] Exit");
        System.out.println("[*] LogOut");
        for (int i = 0; i < 2; i++) System.out.println();

        int input = sc.nextInt();
        int temp = RE_RUN;
        switch (input) {
            case 1 -> {
                // Find book
                while (temp == RE_RUN) {
                    temp = searchBook();
                }
                if (temp == EXIT) return EXIT;
                else if (temp == BACKWARD) return RE_RUN;
            }
            case 2 -> {
                // Return Book
                while (temp == RE_RUN) {
                    temp = searchYourRequest();
                }
                if (temp == EXIT) return EXIT;
                else if (temp == BACKWARD) return RE_RUN;
            }
            case 3 -> {
                // Operate as author right
                if (authorOperation()) return EXIT;
            }
            case 4 -> {
                // User setting
                while (temp == RE_RUN) {
                    temp = userSetting();
                }
                if (temp == EXIT) return EXIT;
                else if (temp == BACKWARD) return RE_RUN;
            }
            case 0 -> {
                return EXIT;
            }
            default -> { 
                // Backward to even before this.
                sc.nextLine();
                return BACKWARD;
            }
        }

        return EXIT;
    }

    
    public static int searchBook() throws SQLException, IOException, Exception {
        clearConsole();
        
        System.out.println("What kind of search you want to follow?\n");
        
        System.out.println("[1] All");
        System.out.println("[2] By Book name");
        System.out.println("[3] By Author");
        System.out.println("[4] By Category");
        System.out.println("[0] Exit");
        System.out.println("[*] Backward");
        for (int i = 0; i < 2; i++) System.out.println();

        int input = sc.nextInt();
        String keyword = "";
        
        
        if (input == 0) return EXIT; // EXIT
        else if (input < 0 || input > 4) return BACKWARD; // Backward
     
        
        int sortBy = 0;
        if (input != 1) sortBy = sortBook();
        
        switch (sortBy) {
            case EXIT -> {
                return EXIT;
            }
            case BACKWARD -> {
                return RE_RUN;
            }
            case 0 -> {
                // nothing
            }
            default -> {
                System.out.print("By keyword: ");
                keyword = sc.nextLine(); // to clear the '\n' at the end of the last line.
                keyword = sc.nextLine();
            }
        }
        
        ArrayList<Book> found;
        switch (input) {
            case 1 -> {// All
                found = Book.findBook("", 1, sortBy);
                break;
            }
            case 2 -> {
                // name
                found = Book.findBook(keyword, 1, sortBy);
                break;
            }
            case 3 -> {
                // Author
                found = Book.findBook(keyword, 3, sortBy);
                break;
            }
            case 4 -> {
                // Category
                found = Book.findBook(keyword, 2, sortBy);
                break;
            }
            case 0 -> { 
                // EXIT
                return EXIT;
            }
            default -> { 
                // Backward
                return BACKWARD;
            }
        }
        
        int temp = RE_RUN;
        while (temp == RE_RUN) {
            temp = choiceBook(found);
        }
        if (temp == BACKWARD) return RE_RUN;
        
        return EXIT;
    }
    
    
    public static int sortBook() {
        System.out.println("How do you want it to be sort?");
        System.out.println("[1] Default");
        System.out.println("[2] By name A-Z");
        System.out.println("[3] By name Z-A");
        System.out.println("[4] By newest release Date");
        System.out.println("[5] By oldest release Date");
        System.out.println("[0] EXIT");
        System.out.println("[*] Backward");
        for (int i = 0; i < 2; i++) System.out.println();
        
        int input = sc.nextInt();
        
        switch (input) {
            case 1 -> {
                // Default
                return 1;
            }
            case 2 -> {
                // By name A-Z
                return 2;
            }
            case 3 -> {
                // By name Z-A
                return 3;
            }
            case 4 -> {
                // By newest release Date
                return 4;
            }
            case 5 -> {
                // By oldest release Date
                return 5;
            }
            case 0 -> {
                // EXIT
                return EXIT;
            }
            default -> {
                // backward
                return BACKWARD;
            }
        }
    }
    
    
    public static int choiceBook(ArrayList<Book> b) throws SQLException, IOException, Exception {
        clearConsole();
        int n = b.size();
        int input;
        
        if (n == 0) {
            System.out.println("Sorry, there no book as you want.");
            System.out.println("[1] Do you want to try a another-keyword");
            System.out.println("[0] EXIT");
            input = sc.nextInt();
            
            if (input == 1) return BACKWARD;
            else return EXIT;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("[" + (i+1) + "] Book " + b.get(i));
        }
        System.out.println("[" + (n+1) + "] Backward");
        System.out.println("[0] EXIT");
        System.out.println("\nPlease enter the book you want to see:");

        
        input = sc.nextInt();
        if (input == 0) return EXIT;
        else if (input == n+1) return BACKWARD;
        else if (input <= n) {
            int temp = RE_RUN;
            while (temp == RE_RUN) {
                temp = tryToRead(b.get(input - 1));
            }
            if (temp == BACKWARD) return RE_RUN;
        } else {
            clearConsole();
            System.out.println("WRONG INDEX.");
            System.out.println("[0] DO YOU WANT TO EXIT?");
            System.out.println("[1] TO RE-TRY");
            System.out.println("[2] OR FIND ANOTHER BOOK?");
            
            n = sc.nextInt();
            if (n == 1) return BACKWARD;
            else if (n == 2) return RE_RUN;
            else return EXIT;
        }
        
        
        System.out.println("THANK YOU FOR VISIT");
        return EXIT;
    } 
    
    
    public static int tryToRead(Book b) throws IOException, SQLException, Exception {
        clearConsole();
        if (b.getQuantity() == 0) {
            System.out.println("Sorry. The book is Out of Stock currently.\nPlease comeback later.");
            return BACKWARD;
            
        } else {
            System.out.println("Select your choice:");
            System.out.println("[1] Try to read for now");
            System.out.println("[2] Borrow the book");
            System.out.println("[0] EXIT");
            System.out.println("[*] Backward");
            
            int input = sc.nextInt();
            
            switch (input) {
                case 1 -> {
                    // Try to read once
                    b.oneTimeOpenBook();
                    return EXIT;
                }
                case 2 -> {
                    currentUser.borrowBook(b.getBookId(), 1);
                    return EXIT;
                }
                case 0 -> {
                    return EXIT;
                }
                default -> {
                    return BACKWARD;
                }
            }
        }
    }

    
    public static int searchYourRequest() throws SQLException {
        clearConsole();
        int input;
        
        System.out.println("Your unreturn list:\n");

        ArrayList<Request> found = currentUser.getMyUnreturnBook();
        int n = found.size();
        if (n == 0) {
            System.out.println("You have no un-return Request.");
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("[" + (i+1) + "] " + found.get(i) + "\n");
        }
        System.out.println("[" + (n+1) + "] Backward");
        System.out.println("[0] EXIT");
        System.out.println("\nPlease enter the request you want to return");
        
        input = sc.nextInt();
        if (input == 0) return EXIT;
        else if (input == n+1) return BACKWARD;
        else if (input <= n) {
            if (currentUser.returnBook(found.get(input - 1))) {
                clearConsole();
                System.out.println("Done");
            } else {
                clearConsole();
                System.out.println("Sorry, some kind of ERROR with our system");
            }
        } else {
            clearConsole();
            System.out.println("WRONG INDEX.");
            System.out.println("[0] DO YOU WANT TO EXIT?");
            System.out.println("[1] OR YOU WANT TO RETRY?");
            
            n = sc.nextInt();
            if (n == 1) return RE_RUN;
            else return EXIT;
        }
        
        
        clearConsole();
        System.out.println("[1] Return another request?");
        System.out.println("[0] EXIT");
        input = sc.nextInt();
        if (input == 1) {
            return RE_RUN;
        }
        
        System.out.println("THANK YOU FOR VISIT");
        return EXIT;
    }
    

    public static boolean authorOperation() {
        clearConsole();
        
        System.out.println("What do you want to do?\n");
        
        System.out.println("[1] Upload documentary");
        System.out.println("[2] Edit your uploaded documentary");
        for (int i = 0; i < 2; i++) System.out.println();

        int input = sc.nextInt();
        System.out.println("System on repair currentlly!!!");
        return false;
    }
    
    
    public static int userSetting() throws SQLException {
        int input;
        String temp;
        System.out.println(currentUser.getInfo());
        
        System.out.println("\nEdit your profile:");
        System.out.println("[1] Change Username");
        System.out.println("[2] Change contact");
        System.out.println("[3] Change password");
        System.out.println("[0] EXIT");
        System.out.println("[*] Bachward");
        
        input = sc.nextInt();
        switch (input) {
            case 1 -> {
                sc.nextLine();
                System.out.println("\n\nPress Enter to EXIT");
                System.out.print("Enter your new UserName: ");
                temp = sc.nextLine();
                if (temp.equals("")) {
                    return BACKWARD;
                } else { 
                    currentUser.changeUserName(temp);
                }
            }
            case 2 -> {
                sc.nextLine();
                System.out.println("\n\nPress Enter to EXIT");
                System.out.print("Enter your new Contact: ");
                temp = sc.nextLine();
                if (temp.equals("")) {
                    return BACKWARD;
                } else { 
                    currentUser.changeContact(temp);
                }
            }
            case 3 -> {
                sc.nextLine();
                String newP;
                System.out.print("\n\nEnter your old Password: ");
                temp = sc.nextLine();
                System.out.print("Enter your new Password: ");
                newP = sc.nextLine();
                System.out.print("Confirm your new Password againt: ");
                if (sc.nextLine().equals(newP)) {
                    if (currentUser.changePassword(temp, newP)) {
                        clearConsole();
                        System.out.println("Change password Success. Please re-LogIn");
                        return EXIT;
                    } else {
                        System.out.println("Change password FAIL.\nPlease, double check your username or password.");
                        return RE_RUN;
                    }
                } else {
                    clearConsole();
                    System.out.println("FAIL to Confirm, you enter 2 different new Password.");
                    temp = sc.nextLine();
                    return RE_RUN;
                }
                
            }
        }
        return EXIT;
    }
}
