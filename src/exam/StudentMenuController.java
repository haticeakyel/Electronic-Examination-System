package exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import exam.pojo.CalculateInfo;
import exam.pojo.DatabaseInfo;
import exam.pojo.ExamProgram;
import exam.pojo.ExaminationSystem;
import exam.pojo.HistoryInfo;
import exam.pojo.PhysicInfo;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

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
	    TableView tablecalculateinfo;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> visaresultCal;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> visapercentCal;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> FinalresultCal;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> FinalpercentCal;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> TotalresultCal;
	 
	 @FXML
		private TableColumn<CalculateInfo, String> DegreeCal;
	 
	 @FXML
	    TableView tabledatabaseinfo;
	 
	 @FXML
		private TableColumn<DatabaseInfo, String> visaresultData;
		
	 @FXML
        private TableColumn<DatabaseInfo, String> visapercentData;
		
	 @FXML
		private TableColumn<DatabaseInfo, String> FinalresultData;
		
	 @FXML
		private TableColumn<DatabaseInfo, String> FinalpercentData;
		
	 @FXML
		private TableColumn<DatabaseInfo, String> TotalresultData;		
	 
	 @FXML
		private TableColumn<DatabaseInfo, String> DegreeData;
		
	 @FXML
	    TableView tablephysicinfo;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> visaresultPhysic;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> visapercentPhysic;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> FinalresultPhysic;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> FinalpercentPhysic;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> TotalresultPhysic;
	 
	 @FXML
		private TableColumn<PhysicInfo, String> DegreePhysic;
	 
	 @FXML
	    TableView tablehistoryinfo;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> visaresultHist;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> visapercentHist;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> FinalresultHist;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> FinalpercentHist;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> TotalresultHist;
	 
	 @FXML
		private TableColumn<HistoryInfo, String> DegreeHist;

	
		
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
		
		private List<CalculateInfo> getAllCalculates() {
			try {
				FileReader fileReader = new FileReader(new File("files/calculateInfo"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<CalculateInfo> calculates = new ArrayList<>();
				
				while ((line = br.readLine()) != null ) {
					CalculateInfo calculateInfo = new CalculateInfo();
					calculateInfo.setCalVisaResult(line.split(":")[2]);
					calculateInfo.setCalVisaPercent(line.split(":")[3]);
					calculateInfo.setCalFinalResult(line.split(":")[4]);
					calculateInfo.setCalFinalPercent(line.split(":")[5]);
					calculateInfo.setCalTotalResult(line.split(":")[6]);
					calculateInfo.setCalDegree(line.split(":")[7]);
					calculates.add(calculateInfo);
				}
				fileReader.close();
				return calculates;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
	 
		private List<DatabaseInfo> getAllDatabases() {
			try {
				FileReader fileReader = new FileReader(new File("files/databaseInfo"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<DatabaseInfo> databases = new ArrayList<>();
				
				while ((line = br.readLine()) != null ) {
					DatabaseInfo databaseInfo = new DatabaseInfo();
					databaseInfo.setDataVisaResult(line.split(":")[2]);
					databaseInfo.setDataVisaPercent(line.split(":")[3]);
					databaseInfo.setDataFinalResult(line.split(":")[4]);
					databaseInfo.setDataFinalPercent(line.split(":")[5]);
					databaseInfo.setDataTotalResult(line.split(":")[6]);
					databaseInfo.setDataDegree(line.split(":")[7]);
					databases.add(databaseInfo);
				}
				fileReader.close();
				return databases;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
		
		private List<PhysicInfo> getAllPhysics() {
			try {
				FileReader fileReader = new FileReader(new File("files/physicInfo"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<PhysicInfo> physics = new ArrayList<>();
				
				while ((line = br.readLine()) != null ) {
					PhysicInfo physicInfo = new PhysicInfo();
					physicInfo.setPhysicVisaResult(line.split(":")[2]);
					physicInfo.setPhysicVisaPercent(line.split(":")[3]);
					physicInfo.setPhysicFinalResult(line.split(":")[4]);
					physicInfo.setPhysicFinalPercent(line.split(":")[5]);
					physicInfo.setPhysicTotalResult(line.split(":")[6]);
					physicInfo.setPhysicDegree(line.split(":")[7]);
					physics.add(physicInfo);
				}
				fileReader.close();
				return physics;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
		
	    private List<HistoryInfo> getAllHistories() {
	    	try {
				FileReader fileReader = new FileReader(new File("files/historyInfo"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<HistoryInfo> histories = new ArrayList<>();
			
				while ((line = br.readLine()) != null ) {
					HistoryInfo historyInfo = new HistoryInfo();
					historyInfo.setHistoryVisaResult(line.split(":")[2]);
					historyInfo.setHistoryVisaPercent(line.split(":")[3]);
					historyInfo.setHistoryFinalResult(line.split(":")[4]);
					historyInfo.setHistoryFinalPercent(line.split(":")[5]);
					historyInfo.setHistoryTotalResult(line.split(":")[6]);
					historyInfo.setHistoryDegree(line.split(":")[7]);
					histories.add(historyInfo);
				}
				fileReader.close();
				return histories;
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
	                	
	                	 List<CalculateInfo> calculates = getAllCalculates();
	                	 visaresultCal.setCellValueFactory(new PropertyValueFactory<>("calVisaResult"));
	                	 visapercentCal.setCellValueFactory(new PropertyValueFactory<>("calVisaPercent"));
	                	 FinalresultCal.setCellValueFactory(new PropertyValueFactory<>("calFinalResult"));
	                	 FinalpercentCal.setCellValueFactory(new PropertyValueFactory<>("calFinalPercent"));
	                	 TotalresultCal.setCellValueFactory(new PropertyValueFactory<>("calTotalResult"));
	                	 DegreeCal.setCellValueFactory(new PropertyValueFactory<>("calDegree"));
	                	 tablecalculateinfo.getItems().setAll(FXCollections.observableArrayList(calculates));
	                	
	                	  List<DatabaseInfo> databases = getAllDatabases();
	                	  visaresultData.setCellValueFactory(new PropertyValueFactory<>("dataVisaResult"));
	                	  visapercentData.setCellValueFactory(new PropertyValueFactory<>("dataVisaPercent"));
	                	  FinalresultData.setCellValueFactory(new PropertyValueFactory<>("dataFinalResult"));
	                	  FinalpercentData.setCellValueFactory(new PropertyValueFactory<>("dataFinalPercent"));
	                	  TotalresultData.setCellValueFactory(new PropertyValueFactory<>("dataTotalResult"));
	                	  DegreeData.setCellValueFactory(new PropertyValueFactory<>("dataDegree"));
	                	  tabledatabaseinfo.getItems().setAll(FXCollections.observableArrayList(databases));
	                	  
	                	  List<PhysicInfo> physics = getAllPhysics();
	                	  visaresultPhysic.setCellValueFactory(new PropertyValueFactory<>("physicVisaResult"));
	                	  visapercentPhysic.setCellValueFactory(new PropertyValueFactory<>("physicVisaPercent"));
	                	  FinalresultPhysic.setCellValueFactory(new PropertyValueFactory<>("physicFinalResult"));
	                	  FinalpercentPhysic.setCellValueFactory(new PropertyValueFactory<>("physicFinalPercent"));
	                	  TotalresultPhysic.setCellValueFactory(new PropertyValueFactory<>("physicTotalResult"));
	                	  DegreePhysic.setCellValueFactory(new PropertyValueFactory<>("physicDegree"));
	                	  tablephysicinfo.getItems().setAll(FXCollections.observableArrayList(physics));
	                	  
	                	  List<HistoryInfo> histories = getAllHistories();
	                	  visaresultHist.setCellValueFactory(new PropertyValueFactory<>("historyVisaResult"));
	                	  visapercentHist.setCellValueFactory(new PropertyValueFactory<>("historyVisaPercent"));
	                	  FinalresultHist.setCellValueFactory(new PropertyValueFactory<>("historyFinalResult"));
	                	  FinalpercentHist.setCellValueFactory(new PropertyValueFactory<>("historyFinalPercent"));
	                	  TotalresultHist.setCellValueFactory(new PropertyValueFactory<>("historyTotalResult"));
	                	  DegreeHist.setCellValueFactory(new PropertyValueFactory<>("historyDegree"));
	                	  tablehistoryinfo.getItems().setAll(FXCollections.observableArrayList(histories));
	                	
	                }

	            }

				
	        }  
	        );
	        }



}