package exam.pojo;

public class CoursesInfo {


    private String coursesCode;
    private String coursesName;
    private String credit;
    private String courseslecturer;
    private String coursesnumberofstudents;
    private String coursesAvg;

    public CoursesInfo(String coursesCode, String coursesName, String credit, String courseslecturer, String coursesnumberofstudents, String coursesAvg){
        this.coursesCode=coursesCode;
        this.coursesName=coursesName;
        this.credit=credit;
        this.courseslecturer=courseslecturer;
        this.coursesnumberofstudents=coursesnumberofstudents;
        this.coursesAvg=coursesAvg;
    }

    public String getCoursesCode() {
    return coursesCode;
   
    }
   
    public void setCoursesCode(String coursesCode) {
    this.coursesCode=coursesCode;
    }
    public String getCoursesName() {
    return coursesName;
    }
   
    public void setCoursesName(String coursesName) {
    this.coursesName=coursesName;
    }
   
    public String getCredit() {
    	return credit;
    }
    
    public void setCredit(String credit) {
    	this.credit=credit;
    }
    
    public String getCourseslecturer() {
    return  courseslecturer;
    }
   
    public void setCourseslecturer(String courseslecturer) {
    this.courseslecturer=courseslecturer;
    }
   
   
    public String getCoursesnumberofstudents() {
    return coursesnumberofstudents;
    }
   
    public void setCoursesnumberofstudents(String coursesnumberofstudents) {
    this.coursesnumberofstudents=coursesnumberofstudents;
    }
   
    public String getCoursesAvg() {
    return coursesAvg;
    }
   
    public void setCoursesAvg(String coursesAvg) {
    	this.coursesAvg=coursesAvg;
    }

}


 
