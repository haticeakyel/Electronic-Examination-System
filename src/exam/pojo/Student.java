package exam.pojo;

public class Student extends User{
   // private String username;
    //private String password;
    private boolean isActive;

    public Student(String username, String password) {
        super(username, password);
    }

    public Student() {
        super();
    }

    /*  public String getUsername() {
          return username;
      }

      public void setUsername(String username) {
          this.username = username;
      }

      public String getPassword() {
          return password;
      }

      public void setPassword(String password) {
          this.password = password;
      }
  */
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}