package exam.pojo;


public class CalculateInfo  {
	
	    private String calStudentName;
	    private String calSchoolNumber;
	    private String calVisaResult;
	    private String calVisaPercent;
	    private String calFinalResult;
	    private String calFinalPercent;
	    private String calTotalResult;
	    private String calDegree;

	    public CalculateInfo(String calStudentName,String calSchoolNumber, String calVisaResult, String calVisaPercent, String calFinalResult, String calFinalPercent, String calTotalResult, String calDegree){
	    	this.calDegree = calDegree;
	    	this.calFinalPercent = calFinalPercent;
	    	this.calFinalResult= calFinalResult;
	    	this.calSchoolNumber = calSchoolNumber;
	    	this.calDegree = calDegree;
	    	this.calTotalResult = calTotalResult;
	    	this.calVisaPercent = calVisaPercent;
	    	this.calVisaResult = calVisaResult;
		}

	    public String getCalStudentName() {
	    	return calStudentName;
	    	
	    }
	    
	    public void setCalStudentName(String calStudentName) {
	    	this.calStudentName=calStudentName;
	    	}
	    
	    public String getCalSchoolNumber() {
	    	return calSchoolNumber;
	    }
	    
	    public void setCalSchoolNumber(String calSchoolNumber) {
	    	this.calSchoolNumber=calSchoolNumber;
	    }
	    
	    public String getCalVisaResult() {
	    	return  calVisaResult;
	    }
	    
	    public void setCalVisaResult(String calVisaResult) {
	    	this.calVisaResult=calVisaResult;
	    }
	    
	    
	    public String getCalVisaPercent() {
	    	return calVisaPercent;
	    }
	    
	    public void setCalVisaPercent(String calVisaPercent) {
	    	this.calVisaPercent=calVisaPercent;
	    }
	    
	    public String getCalFinalResult() {
	    	return calFinalResult;
	    	}
	    
	    public void setCalFinalResult(String calFinalResult) {
	    	this.calFinalResult=calFinalResult;
	    }
	    
	    public String getCalFinalPercent() {
	    	return calFinalPercent;
	    }
	    
	    public void setCalFinalPercent(String calFinalPercent) {
	    	this.calFinalPercent=calFinalPercent;
	    }
	    
	    public String getCalTotalResult() {
	    	return calTotalResult;
	    }
	    
	    public void setCalTotalResult(String calTotalResult) {
	    	this.calTotalResult=calTotalResult;
	    }
	    
	    public String getCalDegree() {
	    	return calDegree;
	    }
	    
	    public void setCalDegree(String calDegree) {
	    	this.calDegree=calDegree;
	    }
	    
}


	  
