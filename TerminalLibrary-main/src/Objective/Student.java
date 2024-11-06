package Objective;


public class Student extends User {
    protected String userName;
    protected String dateOfBirth;
    protected String contact;
    protected String classID;
    protected int age;

    public Student() {
    }

    public Student(String userID, String userName, String dateOfBirth, String contact, String classID, int age) {
        right = SET_STUDENT;
        this.ID = userID;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.classID = classID;
        this.age = age;
    }

    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student " + this.ID + "\n\tuserName = " + userName + "\n\tdateOfBirth = " + dateOfBirth + "\n\tcontact = " + contact + "\n\tclassID = " + classID + "\n\tage = " + age + ".";
    }
    
    
}
