package exam.pojo;

public class Student extends User{

    private boolean isActive;

    public Student(String username, String password) {
        super(username, password);
    }

    public Student() {
        super();
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}