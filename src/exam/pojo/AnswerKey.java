package exam.pojo;
//proxy pattern 
public abstract class AnswerKey {
    private String calstylish;
    private String calanswer;

    public AnswerKey(String calstylish,String calanswer){
        this.calanswer= calanswer;
        this.calstylish=calstylish;
    }
}