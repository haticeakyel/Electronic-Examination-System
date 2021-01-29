package exam;
//factory pattern design
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import exam.pojo.Student;
import javafx.event.ActionEvent;

public class ExamEntryController extends BaseController  {
	
	@FXML
	private Button calculusbscreen;
	
	@FXML
	private Button calculusfscreen;
	
	@FXML
	private TextArea examinfoid;
	
	@FXML
	private Pane stylish;
	
	@FXML
	private Pane backside;
	
	@FXML
	private ToggleGroup slct;
	
	@FXML
	private Button Next;
	
	@FXML
	private Button Finishit;

	@FXML
	private RadioButton questionA;
	

	@FXML
	private RadioButton questionB;

	@FXML
	private RadioButton questionC;
	
	@FXML
	private RadioButton questionD;
	
	@FXML
	private RadioButton questionE;
	
	
	@FXML
	public void calculusbscreenBtn(ActionEvent event) {

		  Parent studentMenuParent;
		try {
			
			studentMenuParent = FXMLLoader.load(getClass().getResource("studentMenu.fxml"));
			Scene scene = new Scene(studentMenuParent);
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	        
	          stage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}

	@FXML
	public void calculusfscreenBtn(ActionEvent event) {

		questionorder=0; 
		markedoptions= new String[questions.size()];
			
			String v=questions.get(questionorder).toString(); 
			
			String[] ss=v.split(":");
			String	s=ss[0]+"\n A)"+ss[1]+"\n B)"+ss[2]+"\n C)"+ss[3]+"\n D)"+ss[4]+"\n E)"+ss[5]+"\n\n\n";
			
		 
		examinfoid.setText(s);
		stylish.setVisible(true);
		backside.setVisible(false);
		Finishit.setVisible(false);
		

	}

	@FXML
	public void finishtheexam(ActionEvent event) throws IOException {
		
		
		Window owner = Finishit.getScene().getWindow();
		 
		AlertHelperExam.showAlert(Alert.AlertType.CONFIRMATION, owner, "Finish the Exam",  "Your exam has been held successfully.");
		
		Parent studentMenuParent = FXMLLoader.load(getClass().getResource("studentMenu.fxml"));
        Scene scene = new Scene(studentMenuParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show(); 

	}
	@FXML
	public void nextQuestion(ActionEvent event) {

		
		if (slct.getSelectedToggle() != null) {

			RadioButton selectedRadioButton = (RadioButton) slct.getSelectedToggle();
			String isaretlenen = selectedRadioButton.getText();
	 

			markedoptions[questionorder]=isaretlenen;
			
			questionorder++;
			
			if(questionorder==(questions.size()-1)) {

				Finishit.setVisible(true); 

				Next.setVisible(false);
			}
			
			if (questionorder<questions.size() ) {	
				
				String v=questions.get(questionorder).toString(); 
				
				String[] ss=v.split(":");
				String s=ss[0]+"\n A)"+ss[1]+"\n B)"+ss[2]+"\n C)"+ss[3]+"\n D)"+ss[4]+"\n E)"+ss[5]+"\n\n\n";
				 
			 
			examinfoid.setText(s); 
			
			}else {
				questionorder--;
			}
			
			
			
        }
		
		for (int i = 0; i < markedoptions.length; i++) {
		
			System.out.print(markedoptions[i]);
		}
		
	}

	
	
	
	public String [] markedoptions;
	public int questionorder=0;
	public String selectExam="";
	public ArrayList<String> questions= new ArrayList<String>();
	public ArrayList<String> info= new ArrayList<String>();
	
	
	public void initialize(URL location, ResourceBundle resources) {
		 
		stylish.setVisible(false);
		
		 FileReader fileReader;
		try {
			fileReader = new FileReader(new File("files/selectExam")); 
	         BufferedReader br = new BufferedReader(fileReader);
	         
				selectExam= br.readLine().trim();
				System.out.println("selectExam "+ selectExam);
			 
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//info = ReadContent("files/"+selectExam+"/examinfo");
		
		try {
			fileReader = new FileReader(new File("files/"+selectExam+"/examinfo"));
            
			String info="";
			String val="";
	        BufferedReader br1 = new BufferedReader(fileReader);
	        
				while ((val = br1.readLine()) != null) {
					
				     info=info+val+"\n"; 
				}
				
				fileReader.close();
				examinfoid.setText(info);
			  
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//factory pattern design
		questions = ReadContent("files/"+selectExam+"/examquestios");
		
		
		
	
		
		
         
	 }


}
