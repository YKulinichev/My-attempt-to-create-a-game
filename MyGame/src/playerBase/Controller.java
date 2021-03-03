package playerBase;

	
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import playerBase.animation.Shake;
import race.RaceMain;

	public class Controller {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField login_filed;

	    @FXML
	    private PasswordField password_filed;

	    @FXML
	    private Button authSignButton;

	    @FXML
	    private Button loginSignUpButton;

	    @FXML
	    void initialize() {
	    	authSignButton.setOnAction(event -> {
	    		String loginText = login_filed.getText().trim();
	    		String loginPassword = password_filed.getText().trim();
	    		if (!loginText.equals("") && !loginPassword.equals("")) {
	    			loginUser (loginText, loginPassword);
	    		}
	    		else {
					System.out.println("Введите логин и пароль");
				}
	    	});
	    		
	    	loginSignUpButton.setOnAction(event -> {
	    		openNewScene("/playerBase/signUp.fxml");
	    
	    	});
	    }

		private void loginUser(String loginText, String loginPassword) {
			DatabaseHandler dbHandler = new DatabaseHandler();
			User user = new User();
			user.setLogin(loginText);
			user.setPassword(loginPassword);
			
			ResultSet result = dbHandler.getUser(user);
			
			int counter = 0;
			try {
				while (result.next()) {
					counter ++;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (counter >= 1) {
				
				
				//starting racing
				System.out.println("Starting an app");
	          
				try {
				RaceMain.main(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("проверка");
			   

			    			
			}
			else {
				Shake userLoginAnim = new Shake(login_filed);
				Shake userPassAnim = new Shake(password_filed);
				userLoginAnim.playAnim();
				userPassAnim.playAnim();
			}
		}
		
		public void openNewScene(String window) {

    		loginSignUpButton.getScene().getWindow().hide();
    		
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource(window));
    		try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    		
    		Parent root = loader.getRoot();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
    		stage.showAndWait();
		}
	}

	
