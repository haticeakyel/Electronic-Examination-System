package exam;

import java.io.IOException;

import javafx.event.ActionEvent;

 //state pattern
public abstract class BaseLoginController {
	
	abstract void login(ActionEvent actionEvent) throws IOException;

}
