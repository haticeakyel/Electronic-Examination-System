package exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

//factory design pattern

public abstract  class BaseController implements Initializable  {

	

	public   ArrayList<String> ReadContent(String filepath) {
		 ArrayList<String> content= new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(new File(filepath));
           
			String info="";
			String val="";
	        BufferedReader br2 = new BufferedReader(fileReader);
	        
				while ((val = br2.readLine()) != null) {
					
					content.add(val);
				}
				
				fileReader.close();  
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content; 
	


	}}




