package exam.pojo;

public class CalculusAnswerKey {
	private String calstylish;
	private String calanswer;

	public CalculusAnswerKey(String calstylish, String calanswer){
		this.calanswer= calanswer;
		this.calstylish = calstylish;
	}


	
	public String getCalstylish() {
		return calstylish;
	}
	
	public void setCalstylish(String calstylish) {
		this.calstylish=calstylish;
	}
	
	public String  getCalanswer() {
		return calanswer;
	}
	
	public void setCalanswer(String calanswer) {
		this.calanswer=calanswer;
	}
	
}