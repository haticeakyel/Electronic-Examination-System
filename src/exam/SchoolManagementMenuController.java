package exam;

    import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.FXCollections;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
	import javafx.scene.control.*;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.stage.Window;
    import exam.pojo.CalculateInfo;
    import exam.pojo.CoursesInfo;
    import exam.pojo.DatabaseInfo;
    import exam.pojo.HistoryInfo;
    import exam.pojo.PhysicInfo;

    import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.ResourceBundle;

	public class SchoolManagementMenuController implements Initializable {

	    @FXML
	    TableView calculateInfo;
	    
	    @FXML
	    private TabPane schoolManagementSelectPan;
	    
		@FXML
		private TableColumn<CalculateInfo, String> calstdName;

		@FXML
		private TableColumn<CalculateInfo, String> calstdNumber;
		
		@FXML
		private TableColumn<CalculateInfo, String> calvisaResult;
		
		@FXML
		private TableColumn<CalculateInfo, String> calvisaPercent;
		
		@FXML
		private TableColumn<CalculateInfo, String> calfinalResult;
		
		@FXML
		private TableColumn<CalculateInfo, String> calfinalPercent;
		
		@FXML
		private TableColumn<CalculateInfo, String> calTotalResult;
		
		@FXML
		private TableColumn<CalculateInfo, String> calDegree;
	
		@FXML
	    TableView calculateSerch;
		
		@FXML
		private TableColumn<CalculateInfo, String> calstdNameSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calstdNumberSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calvisaResultSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calvisaPercentSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calfinalResultSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calfinalPercentSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> caltotalResultSerch;
	
		@FXML
		private TableColumn<CalculateInfo, String> calDegreeSerch;
		
	    @FXML
		private TextField calculateStdSerch;
	
	    @FXML
	    private Button calculateSerchBtn;
	  
	    @FXML
	    TableView databaseInfo;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datastdName;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datastdNumber;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datavisaResult;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datavisaPercent;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datafinalResult;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datafinalPercent;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datatotalResult;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> dataDegree;
	    
	    @FXML
	    TableView databaseSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datastdNameSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datastdNumberSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datavisaResultSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datavisaPercentSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datafinalResultSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datafinalPercentSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> datatotalResultSerch;
	    
	    @FXML
		private TableColumn<DatabaseInfo, String> dataDegreeSerch;
	    
	    @FXML
		private TextField dataStdSerch;
	    
	    @FXML
	    private Button dataSerchBtn;
	    
	    @FXML
	    TableView physicInfo;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicstdName;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicstdNumber;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicvisaResult;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicvisaPercent;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicfinalResult;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicfinalPercent;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physictotalResult;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicDegree;
	    
	    @FXML
	    TableView physicSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicstdNameSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicstdNumberSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicvisaResultSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicvisaPercentSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicfinalResultSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicfinalPercentSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physictotalResultSerch;
	    
	    @FXML
		private TableColumn<PhysicInfo, String> physicDegreeSerch;
	    
	    @FXML
		private TextField physicStdSerch;
	    
	    @FXML
	    private Button physicSerchBtn;
	    
	    @FXML
	    TableView historyInfo;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historystdName;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historystdNumber;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyvisaResult;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyvisaPercent;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyfinalResult;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyfinalPercent;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historytotalResult;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historydegree;
	    
	    @FXML
	    TableView historySerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historystdNameSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historystdNumberSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyvisaResultSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyvisaPercentSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyfinalResultSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historyfinalPercentSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historytotalResultSerch;
	    
	    @FXML
		private TableColumn<HistoryInfo, String> historydegreeSerch;
	    
	    @FXML
		private TextField historystdSerch;
	    
	    @FXML
	    private Button historySerchBtn;
	    
	    @FXML
	    TableView courseInfo;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseCode;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseName;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseCredit;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseLecturer;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseNumStd;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseAvg;
	    
	    @FXML
	    TableView courseSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseCodeSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseNameSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseCreditSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseLecturerSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseNumStdSerch;
	    
	    @FXML
		private TableColumn<CoursesInfo, String> courseAvgSerch;
	    
	    @FXML
		private TextField courseInfoSerch;
	    
	    @FXML
	    private Button courseInfoSerchBtn;
	    
	    
	    @FXML
		public void calculateSerch(ActionEvent event) {
			Window owner = calculateSerchBtn.getScene().getWindow();
			try {

				List<CalculateInfo> calculates = getAllCalculates();
				
				boolean isStockExist = calculates.stream().anyMatch(myCalculateInfo -> myCalculateInfo.getCalSchoolNumber().equals(calculateStdSerch.getText()));
				
				if (isStockExist) {
					
					Iterator<CalculateInfo> calculateIterator = calculates.iterator();
					
					while(calculateIterator.hasNext()) {
						CalculateInfo calculate = calculateIterator.next();
						if (!calculate.getCalSchoolNumber().equals(calculateStdSerch.getText())) {
							calculateIterator.remove();
						}
					
					}
					
					calstdNameSerch.setCellValueFactory(new PropertyValueFactory<>("calStudentName"));
					calstdNumberSerch.setCellValueFactory(new PropertyValueFactory<>("calSchoolNumber"));
					calvisaResultSerch.setCellValueFactory(new PropertyValueFactory<>("calVisaResult"));
					calvisaPercentSerch.setCellValueFactory(new PropertyValueFactory<>("calVisaPercent"));
					calfinalResultSerch.setCellValueFactory(new PropertyValueFactory<>("calFinalResult"));
					calfinalPercentSerch.setCellValueFactory(new PropertyValueFactory<>("calFinalPercent"));
					caltotalResultSerch.setCellValueFactory(new PropertyValueFactory<>("calTotalResult"));
					calDegreeSerch.setCellValueFactory(new PropertyValueFactory<>("calDegree"));
					
					calculateSerch.getItems().setAll(FXCollections.observableArrayList(calculates));

				} else {
					AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "CalculateInfo",
							"No student found.");
				}
			} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "CalculateInfo",
						"No student found.Try Again.");
			}
		}
	    
	    
	    
	    @FXML
		public void dataSerch(ActionEvent event) {
			Window owner = dataSerchBtn.getScene().getWindow();
			try {

				List<DatabaseInfo> databases = getAllDatabases();
				
				boolean isStockExist = databases.stream().anyMatch(myDatabaseInfo -> myDatabaseInfo.getDataSchoolNumber().equals(dataStdSerch.getText()));
				
				if (isStockExist) {
					
					Iterator<DatabaseInfo> databaseIterator = databases.iterator();
					
					while(databaseIterator.hasNext()) {
						DatabaseInfo database = databaseIterator.next();
						if (!database.getDataSchoolNumber().equals(dataStdSerch.getText())) {
							databaseIterator.remove();
						}
					
					}
					
					datastdNameSerch.setCellValueFactory(new PropertyValueFactory<>("dataStudentName"));
					datastdNumberSerch.setCellValueFactory(new PropertyValueFactory<>("dataSchoolNumber"));
					datavisaResultSerch.setCellValueFactory(new PropertyValueFactory<>("dataVisaResult"));
					datavisaPercentSerch.setCellValueFactory(new PropertyValueFactory<>("dataVisaPercent"));
					datafinalResultSerch.setCellValueFactory(new PropertyValueFactory<>("dataFinalResult"));
					datafinalPercentSerch.setCellValueFactory(new PropertyValueFactory<>("dataFinalPercent"));
					datatotalResultSerch.setCellValueFactory(new PropertyValueFactory<>("dataTotalResult"));
					dataDegreeSerch.setCellValueFactory(new PropertyValueFactory<>("dataDegree"));
					
					databaseSerch.getItems().setAll(FXCollections.observableArrayList(databases));

				} else {
					AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "DatabaseInfo",
							"No student found.");
				}
			} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "DatabaseInfo",
						"No student found.Try Again.");
			}
		}
	    
	    
	    @FXML
		public void physicSerch(ActionEvent event) {
			Window owner = physicSerchBtn.getScene().getWindow();
			try {

				List<PhysicInfo> physics = getAllPhysics();
				
				boolean isStockExist = physics.stream().anyMatch(myPhysicInfo -> myPhysicInfo.getPhysicSchoolNumber().equals(physicStdSerch.getText()));
				
				if (isStockExist) {
					
					Iterator<PhysicInfo> physicIterator = physics.iterator();
					
					while(physicIterator.hasNext()) {
						PhysicInfo physic = physicIterator.next();
						if (!physic.getPhysicSchoolNumber().equals(physicStdSerch.getText())) {
							physicIterator.remove();
						}
					
					}
					
					physicstdNameSerch.setCellValueFactory(new PropertyValueFactory<>("physicStudentName"));
					physicstdNumberSerch.setCellValueFactory(new PropertyValueFactory<>("physicSchoolNumber"));
					physicvisaResultSerch.setCellValueFactory(new PropertyValueFactory<>("physicVisaResult"));
					physicvisaPercentSerch.setCellValueFactory(new PropertyValueFactory<>("physicVisaPercent"));
					physicfinalResultSerch.setCellValueFactory(new PropertyValueFactory<>("physicFinalResult"));
					physicfinalPercentSerch.setCellValueFactory(new PropertyValueFactory<>("physicFinalPercent"));
					physictotalResultSerch.setCellValueFactory(new PropertyValueFactory<>("physicTotalResult"));
					physicDegreeSerch.setCellValueFactory(new PropertyValueFactory<>("physicDegree"));
					
					physicSerch.getItems().setAll(FXCollections.observableArrayList(physics));

				} else {
					AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "PhysicInfo",
							"No student found.");
				}
			} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "PhysicInfo",
						"No student found.Try Again.");
			}
	    }
	    
	    @FXML
		public void historySerch(ActionEvent event) {
			Window owner = historySerchBtn.getScene().getWindow();
			try {

				List<HistoryInfo> histories = getAllHistories();
				
				boolean isStockExist = histories.stream().anyMatch(myHistoryInfo -> myHistoryInfo.getHistorySchoolNumber().equals(historystdSerch.getText()));
				
				if (isStockExist) {
					
					Iterator<HistoryInfo> historyIterator = histories.iterator();
					
					while(historyIterator.hasNext()) {
						HistoryInfo history = historyIterator.next();
						if (!history.getHistorySchoolNumber().equals(historystdSerch.getText())) {
							historyIterator.remove();
						}
					
					}
					
					historystdNameSerch.setCellValueFactory(new PropertyValueFactory<>("historyStudentName"));
					historystdNumberSerch.setCellValueFactory(new PropertyValueFactory<>("historySchoolNumber"));
					historyvisaResultSerch.setCellValueFactory(new PropertyValueFactory<>("historyVisaResult"));
					historyvisaPercentSerch.setCellValueFactory(new PropertyValueFactory<>("historyVisaPercent"));
					historyfinalResultSerch.setCellValueFactory(new PropertyValueFactory<>("historyFinalResult"));
					historyfinalPercentSerch.setCellValueFactory(new PropertyValueFactory<>("historyFinalPercent"));
					historytotalResultSerch.setCellValueFactory(new PropertyValueFactory<>("historyTotalResult"));
					historydegreeSerch.setCellValueFactory(new PropertyValueFactory<>("historyDegree"));
					
					historySerch.getItems().setAll(FXCollections.observableArrayList(histories));

				} else {
					AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "HistoryInfo",
							"No student found.");
				}
			} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "HistoryInfo",
						"No student found.Try Again.");
			}
	    }
	    
	    
	    @FXML
		public void courseInfoSerch(ActionEvent event) {
			Window owner = courseInfoSerchBtn.getScene().getWindow();
			try {

				List<CoursesInfo> courses =getAllCourse();
				
				boolean isStockExist = courses.stream().anyMatch(myCoursesInfo -> myCoursesInfo.getCoursesCode().equals(courseInfoSerch.getText()));
				
				if (isStockExist) {
					
					Iterator<CoursesInfo> courseIterator = courses.iterator();
					
					while(courseIterator.hasNext()) {
						CoursesInfo course = courseIterator.next();
						if (!course.getCoursesCode().equals(courseInfoSerch.getText())) {
							courseIterator.remove();
						}
					
					}
					
					courseCodeSerch.setCellValueFactory(new PropertyValueFactory<>("coursesCode"));
					courseNameSerch.setCellValueFactory(new PropertyValueFactory<>("coursesName"));
					courseCreditSerch.setCellValueFactory(new PropertyValueFactory<>("credit"));
					courseLecturerSerch.setCellValueFactory(new PropertyValueFactory<>("courseslecturer"));
					courseNumStdSerch.setCellValueFactory(new PropertyValueFactory<>("coursesnumberofstudents"));
					courseAvgSerch.setCellValueFactory(new PropertyValueFactory<>("coursesAvg"));
					
					courseSerch.getItems().setAll(FXCollections.observableArrayList(courses));

				} else {
					AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "CoursesInfo",
							"No student found.");
				}
			} catch (Exception e) {

				AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "CoursesInfo",
						"No student found.Try Again.");
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
	                calculateInfo.setCalStudentName(line.split(":")[0]);
	                calculateInfo.setCalSchoolNumber(line.split(":")[1]);
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
					databaseInfo.setDataStudentName(line.split(":")[0]);
					databaseInfo.setDataSchoolNumber(line.split(":")[1]);
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
					physicInfo.setPhysicStudentName(line.split(":")[0]);
					physicInfo.setPhysicSchoolNumber(line.split(":")[1]);
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
					historyInfo.setHistoryStudentName(line.split(":")[0]);
					historyInfo.setHistorySchoolNumber(line.split(":")[1]);
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
	    
	    private List<CoursesInfo> getAllCourse() {
	    	try {
				FileReader fileReader = new FileReader(new File("files/coursesInfo"));
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				List<CoursesInfo> courses = new ArrayList<>();
				while ((line = br.readLine()) != null ) {
					CoursesInfo coursesInfo = new CoursesInfo();
					coursesInfo.setCoursesCode(line.split(":")[0]);
					coursesInfo.setCoursesName(line.split(":")[1]);
					coursesInfo.setCredit(line.split(":")[2]);
					coursesInfo.setCourseslecturer(line.split(":")[3]);
					coursesInfo.setCoursesnumberofstudents(line.split(":")[4]);
					coursesInfo.setCoursesAvg(line.split(":")[5]);
					courses.add(coursesInfo);
				}
				fileReader.close();
				return courses;
				} catch (Exception e) {
				return new ArrayList<>();
			}
		}
	    

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {

	        List<CalculateInfo> calculates = getAllCalculates();
	        calstdName.setCellValueFactory(new PropertyValueFactory<>("calStudentName"));
	        calstdNumber.setCellValueFactory(new PropertyValueFactory<>("calSchoolNumber"));
	        calvisaResult.setCellValueFactory(new PropertyValueFactory<>("calVisaResult"));
	        calvisaPercent.setCellValueFactory(new PropertyValueFactory<>("calVisaPercent"));
	        calfinalResult.setCellValueFactory(new PropertyValueFactory<>("calFinalResult"));
	        calfinalPercent.setCellValueFactory(new PropertyValueFactory<>("calFinalPercent"));
	        calTotalResult.setCellValueFactory(new PropertyValueFactory<>("calTotalResult"));
	        calDegree.setCellValueFactory(new PropertyValueFactory<>("calDegree"));
	        calculateInfo.getItems().setAll(FXCollections.observableArrayList(calculates));
	        schoolManagementSelectPan.getTabs().get(0).setContent(calculateInfo);


	        schoolManagementSelectPan.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
	            @Override
	            public void changed(ObservableValue<? extends Tab> ov, Tab tabOld, Tab tabNew) {

	                if (tabNew.getText().equals("CalculateStdInfo")) {
	                	
	                	  List<CalculateInfo> calculates = getAllCalculates();
	          	        calstdName.setCellValueFactory(new PropertyValueFactory<>("calStudentName"));
	          	        calstdNumber.setCellValueFactory(new PropertyValueFactory<>("calSchoolNumber"));
	          	        calvisaResult.setCellValueFactory(new PropertyValueFactory<>("calVisaResult"));
	          	        calvisaPercent.setCellValueFactory(new PropertyValueFactory<>("calVisaPercent"));
	          	        calfinalResult.setCellValueFactory(new PropertyValueFactory<>("calFinalResult"));
	          	        calfinalPercent.setCellValueFactory(new PropertyValueFactory<>("calFinalPercent"));
	          	        calTotalResult.setCellValueFactory(new PropertyValueFactory<>("calTotalResult"));
	          	        calDegree.setCellValueFactory(new PropertyValueFactory<>("calDegree"));
	          	        calculateInfo.getItems().setAll(FXCollections.observableArrayList(calculates));
	          	      
	                }
	                
	                else if (tabNew.getText().equals("CanculateSdtISerch")){
	                
	                	Window owner = calculateSerchBtn.getScene().getWindow();
	                }
	                
	                else if (tabNew.getText().equals("DataBaseStdInfo")) {
	                	
	                	  List<DatabaseInfo> databases = getAllDatabases();
	                	  datastdName.setCellValueFactory(new PropertyValueFactory<>("dataStudentName"));
	                	  datastdNumber.setCellValueFactory(new PropertyValueFactory<>("dataSchoolNumber"));
	                	  datavisaResult.setCellValueFactory(new PropertyValueFactory<>("dataVisaResult"));
	                	  datavisaPercent.setCellValueFactory(new PropertyValueFactory<>("dataVisaPercent"));
	                	  datafinalResult.setCellValueFactory(new PropertyValueFactory<>("dataFinalResult"));
	                	  datafinalPercent.setCellValueFactory(new PropertyValueFactory<>("dataFinalPercent"));
	                	  datatotalResult.setCellValueFactory(new PropertyValueFactory<>("dataTotalResult"));
	                	  dataDegree.setCellValueFactory(new PropertyValueFactory<>("dataDegree"));
	                	  databaseInfo.getItems().setAll(FXCollections.observableArrayList(databases));
	                	  
	                }
	                
	                else if (tabNew.getText().equals("DataBaseStdSerch")){
		                
	                	Window owner = dataSerchBtn.getScene().getWindow();
	                }
	                
	                else if (tabNew.getText().equals("PhysicStdInfo")) {
	                	
	                	  List<PhysicInfo> physics = getAllPhysics();
	                	  physicstdName.setCellValueFactory(new PropertyValueFactory<>("physicStudentName"));
	                	  physicstdNumber.setCellValueFactory(new PropertyValueFactory<>("physicSchoolNumber"));
	                	  physicvisaResult.setCellValueFactory(new PropertyValueFactory<>("physicVisaResult"));
	                	  physicvisaPercent.setCellValueFactory(new PropertyValueFactory<>("physicVisaPercent"));
	                	  physicfinalResult.setCellValueFactory(new PropertyValueFactory<>("physicFinalResult"));
	                	  physicfinalPercent.setCellValueFactory(new PropertyValueFactory<>("physicFinalPercent"));
	                	  physictotalResult.setCellValueFactory(new PropertyValueFactory<>("physicTotalResult"));
	                	  physicDegree.setCellValueFactory(new PropertyValueFactory<>("physicDegree"));
	                	  physicInfo.getItems().setAll(FXCollections.observableArrayList(physics));
	                }
	              
                   else if (tabNew.getText().equals("PhysicStdSerch")){
		                
	                	Window owner = physicSerchBtn.getScene().getWindow();
	                }
	                
                   else if (tabNew.getText().equals("HistoryStdInfo")) {
	                	
	                	  List<HistoryInfo> histories = getAllHistories();
	                	  historystdName.setCellValueFactory(new PropertyValueFactory<>("historyStudentName"));
	                	  historystdNumber.setCellValueFactory(new PropertyValueFactory<>("historySchoolNumber"));
	                	  historyvisaResult.setCellValueFactory(new PropertyValueFactory<>("historyVisaResult"));
	                	  historyvisaPercent.setCellValueFactory(new PropertyValueFactory<>("historyVisaPercent"));
	                	  historyfinalResult.setCellValueFactory(new PropertyValueFactory<>("historyFinalResult"));
	                	  historyfinalPercent.setCellValueFactory(new PropertyValueFactory<>("historyFinalPercent"));
	                	  historytotalResult.setCellValueFactory(new PropertyValueFactory<>("historyTotalResult"));
	                	  historydegree.setCellValueFactory(new PropertyValueFactory<>("historyDegree"));
	                	  historyInfo.getItems().setAll(FXCollections.observableArrayList(histories));
	                }
	                
                   else if (tabNew.getText().equals("HistoryStdSerch")){
		                
	                	Window owner = historySerchBtn.getScene().getWindow();
	                }
	                
                   else if (tabNew.getText().equals("CoursesInfo")) {
	                	
	                	  List<CoursesInfo> courses = getAllCourse();
	                	  courseCode.setCellValueFactory(new PropertyValueFactory<>("coursesCode"));
	                	  courseName.setCellValueFactory(new PropertyValueFactory<>("coursesName"));
	                	  courseCredit.setCellValueFactory(new PropertyValueFactory<>("credit"));
	                	  courseLecturer.setCellValueFactory(new PropertyValueFactory<>("courseslecturer"));
	                	  courseNumStd.setCellValueFactory(new PropertyValueFactory<>("coursesnumberofstudents"));
	                	  courseAvg.setCellValueFactory(new PropertyValueFactory<>("coursesAvg"));
	                	  courseInfo.getItems().setAll(FXCollections.observableArrayList(courses));
	                }
	                
                   else if (tabNew.getText().equals("CoursesSerch")){
		                
	                	Window owner = courseInfoSerchBtn.getScene().getWindow();
	                }
	            }

				

				

				

				
	        });
	    }








	}
