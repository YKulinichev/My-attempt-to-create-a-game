package playerBase;
//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_filed;

    @FXML
    private PasswordField password_filed;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpCountry;

    @FXML
    private RadioButton signUpChekBoxMale;

    @FXML
    private RadioButton signUpChekBoxFemale;
    
    @FXML
    void initialize() {
    	
    	
    	signUpButton.setOnAction(event -> {
    		
    		
    		singnUpNewUser();
    		
    		JOptionPane.showMessageDialog(null, "Registration complite");
    		    				
    		System.exit(1);
    		});
    	
    		  	
    }

	private void singnUpNewUser() {
		DatabaseHandler dbHandler = new DatabaseHandler();
		String firstName=signUpName.getText();
		 String lastName=signUpLastName.getText();
		 String login=login_filed.getText();
		 String password=password_filed.getText();
		 String country=signUpCountry.getText();
		 String gender="";
		 if (signUpChekBoxMale.isSelected()) {
			 gender= "Male";}
		 else
		 {gender= "Female";}
		 
		 User user = new User(firstName,lastName,login,password,country,gender);
		 
		dbHandler.signUpUser(user);
		
			
		
	}
	
	
}