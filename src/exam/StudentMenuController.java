package exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import exam.pojo.CalculateInfo;
import exam.pojo.DatabaseInfo;
import exam.pojo.ExamProgram;
import exam.pojo.ExamResult;
import exam.pojo.ExaminationSystem;
import exam.pojo.HistoryInfo;
import exam.pojo.PhysicInfo;
import exam.pojo.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

//template design pattern

public class StudentMenuController implements Initializable {

	 @FXML
	    TableView tableviewexam;
	 
	 @FXML
	    private TabPane studentSelectTabPane;
	 
	 @FXML
		private TableColumn<ExaminationSystem, String> coursecode;
	
	 @FXML
		private TableColumn<ExaminationSystem, String> coursename;
	 
	 @FXML
		private TableColumn<ExaminationSystem, String> examtype;
	 
	 @FXML
		private TableColumn<ExaminationSystem, String> examdate;
	 
	 @FXML
		private TableColumn<ExaminationSystem, String> examtime;
	 
	
	 @FXML
	    private Button gotoExam;
	 
	 @FXML
	    TableView tableviewprogram;
	 
	 @FXML
		private TableColumn<ExamProgram, String> courseName;
	 
	 @FXML
		private TableColumn<ExamProgram, String> examType;
	 
	 @FXML
		private TableColumn<ExamProgram, String> examDate;
	 
	 @FXML
		private TableColumn<ExamProgram, String> examHour;
	 
	 @FXML
		private TableColumn<ExamProgram, String> examClass;
	 
	 @FXML
	    private Button stdNumEnter;
	 
	 @FXML
	    TableView tableResulteinfo;

	 
/* @FXML
		private TableColumn<ExamResult, String> sclNumResult;
	*/ 
	 @FXML
		private TableColumn<ExamResult, String> lessonResult;
	
	 @FXML
		private TableColumn<ExamResult, String> visaresultResult;
	 
	 @FXML
		private TableColumn<ExamResult, String> visapercentResult;
	 
	 @FXML
		private TableColumn<ExamResult, String> FinalresultResult;
	 
	 @FXML
		private TableColumn<ExamResult, String> FinalpercentResult;
	 
	 @FXML
		private TableColumn<ExamResult, String> TotalresultResult;
	 
	 @FXML
		private TableColumn<ExamResult, String> DegreeResult;
	 
	 @FXML
		private TextField stdNumResult;
 
	 
	 
		
	 @FXML
		public void examBtn(ActionEvent event) throws IOException {
		 
		     System.out.println("entry"); 
		    
		     ExaminationSystem es = (ExaminationSystem) tableviewexam.getSelectionModel().getSelectedItem();
		     if (es!=null) {
		    	
		    	    System.out.println(es.getSystemCourseCode());    
		    	    FileWriter fiw= new FileWriter(new File("files/selectExam"));
		    	    fiw.write(es.getSystemCourseCode());
		    	    fiw.close();
		    	    
		            Parent studentMenuParent = FXMLLoader.load(getClass().getResource("ExamLoginScreen.fxml"));
		            Scene scene = new Scene(studentMenuParent);
		            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		            stage.setScene(scene);
		            stage.show(); 
			}
		     
            else {
            	 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Please select your exam.");
                 alert.setHeaderText(null);
                 alert.setContentText("Please select your exam."); 
                 alert.show();
            }
	 }
	 
	 
	
		
			
	        @FXML
		    public void stdNumEnterBtn(ActionEvent evet) {
	        	
			Window owner = stdNumEnter.getScene().getWindow();
			
			try {

				ArrayList<ExamResult> examResults = getAllExamResults();
                
		
				ArrayList<ExamResult> examResults2= new ArrayList<ExamResult>();
			 
				for (int i = 0; i < examResults.size(); i++) {
					String s1= examResults.get(i).getRsltstudentNumber()==null?"":examResults.get(i).getRsltstudentNumber();

					String s2= stdNumResult.getText();
					
					if (s1.equals(s2)) { 
						
						examResults2.add(examResults.get(i));
					}}

				
				
				
				lessonResult.setCellValueFactory(new PropertyValueFactory<>("rsltLesson"));
				visaresultResult.setCellValueFactory(new PropertyValueFactory<>("rstlvisaResult"));
				visapercentResult.setCellValueFactory(new PropertyValueFactory<>("rsltvisaPercent"));
				FinalresultResult.setCellValueFactory(new PropertyValueFactory<>("rsltfinalResult"));
				FinalpercentResult.setCellValueFactory(new PropertyValueFactory<>("rsltfinalPercent"));
				TotalresultResult.setCellValueFactory(new PropertyValueFactory<>("rsltotalResult"));
				DegreeResult.setCellValueFactory(new PropertyValueFactory<>("rsltDegree"));
				
				
				tableResulteinfo.getItems().setAll(FXCollections.observableArrayList(examResults2));
 
				} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "ExamResult",
						"No student found.Try Again.");
			}
		}
	        
			
	
	
	        
	    	public ArrayList<ExamResult> getAllExamResults() {
	    		try {
	    			FileReader fileReader = new FileReader(new File("files/examResult"));
	    			BufferedReader br = new BufferedReader(fileReader);
	    			String line;
	    			ArrayList<ExamResult> examResults = new ArrayList<ExamResult>();

	    			while ((line = br.readLine()) != null && line.length() > 0) {
	    				ExamResult examResult = new ExamResult();

	    			    examResult.setRsltstudentNumber(line.split(":")[0]);
						examResult.setRsltLesson(line.split(":")[1]);
						examResult.setRstlvisaResult(line.split(":")[2]);
						examResult.setRsltvisaPercent(line.split(":")[3]);
						examResult.setRsltfinalResult(line.split(":")[4]);
						examResult.setRsltfinalPercent(line.split(":")[5]);
						examResult.setRsltotalResult(line.split(":")[6]);
						examResult.setRsltDegree(line.split(":")[7]);
						examResults.add(examResult);
	    			}
	    			fileReader.close();
	    			return examResults;
	    		} catch (Exception e) {
	    			return null;
	    		}
	    	}
	    	
	       

		private ArrayList<ExaminationSystem> getAllExams() {
			try {
				FileReader fileReader = new FileReader(new File("files/examinationSystem"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				
				ArrayList<ExaminationSystem> exams = new ArrayList<ExaminationSystem>();
				
				while ((line = br.readLine()) != null ) {
					ExaminationSystem examinationSystem = new ExaminationSystem();
					examinationSystem.setSystemCourseCode(line.split(":")[0]);
					examinationSystem.setSystemCourseName(line.split(":")[1]);
					examinationSystem.setSystemExamType(line.split(":")[2]);
					examinationSystem.setSystemExamDate(line.split(":")[3]);
					examinationSystem.setSystemExamTime(line.split(":")[4]);
					exams.add(examinationSystem);
				}
				fileReader.close();
				return exams;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
		
		private List<ExamProgram> getAllPrograms() {
			try {
				FileReader fileReader = new FileReader(new File("files/examProgram"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<ExamProgram> programs = new ArrayList<>();
				
				while ((line = br.readLine()) != null ) {
					ExamProgram examProgram = new ExamProgram();
					examProgram.setCourseName(line.split(":")[0]);
					examProgram.setExamType(line.split(":")[1]);
					examProgram.setExamDate(line.split(":")[2]);
					examProgram.setExamTime(line.split(":")[3]);
					examProgram.setExamClass(line.split(":")[4]);
					programs.add(examProgram);
				}
				fileReader.close();
				return programs;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
		
 
	    public void initialize(URL location, ResourceBundle resources) {

	        List<ExaminationSystem> exams = getAllExams();
	        
	        coursecode.setCellValueFactory(new PropertyValueFactory<>("systemCourseCode"));
	        coursename.setCellValueFactory(new PropertyValueFactory<>("systemCourseName"));
	        examtype.setCellValueFactory(new PropertyValueFactory<>("systemExamType"));
	        examdate.setCellValueFactory(new PropertyValueFactory<>("systemExamDate"));
	        examtime.setCellValueFactory(new PropertyValueFactory<>("systemExamTime"));
	        tableviewexam.getItems().setAll(FXCollections.observableArrayList(exams));
	      

 
	         studentSelectTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
	          //template design pattern
	        	 @Override
	            public void changed(ObservableValue<? extends Tab> ov, Tab tabOld, Tab tabNew) {

	                if (tabNew.getText().equals("Electronic Examination System")) {
	                	
	                	  List<ExaminationSystem> exams = getAllExams();
	                	  coursecode.setCellValueFactory(new PropertyValueFactory<>("systemCourseCode"));
	          	        coursename.setCellValueFactory(new PropertyValueFactory<>("systemCourseName"));
	          	        examtype.setCellValueFactory(new PropertyValueFactory<>("systemExamType"));
	          	        examdate.setCellValueFactory(new PropertyValueFactory<>("systemExamDate"));
	          	        examtime.setCellValueFactory(new PropertyValueFactory<>("systemExamTime"));
	          	        tableviewexam.getItems().setAll(FXCollections.observableArrayList(exams));
	          	        
                          
							Window owner = gotoExam.getScene().getWindow();
		          	  
	          	     
	          	        
	                }
	                
	                else if (tabNew.getText().equals("Exam Program")){
	                
	                	 List<ExamProgram> programs = getAllPrograms();
	                	 courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
	                	 examType.setCellValueFactory(new PropertyValueFactory<>("examType"));
	                	 examDate.setCellValueFactory(new PropertyValueFactory<>("examDate"));
	                	 examHour.setCellValueFactory(new PropertyValueFactory<>("examTime"));
	                	 examClass.setCellValueFactory(new PropertyValueFactory<>("examClass"));
	                	 tableviewprogram.getItems().setAll(FXCollections.observableArrayList(programs));
	                	
	                }
	                
	                else if (tabNew.getText().equals("My Exam Result")){
	                	
	                	Window owner = stdNumEnter.getScene().getWindow();
	              
	                	
	                	
	                	
	                }

	            }

				
	        }  
	        );
	        }



}