import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginPage extends BorderPane{
    //TODO change the temp password
    String tempPassword = "football";
    String tempLogin = "1234567";
    private Button login, createAccount;
    private PasswordField passwordField;
    private TextField loginField;
    private Label loginLabel;
    private Label passwordLabel;
    private GridPane pane;
    private Label bankName;
    private Label incorrect;
    EagleBank bank;
    LoginPage(EagleBank bank){
        this.bank = bank;
        pane = new GridPane();
        login = new Button();
        createAccount = new Button("Create Account");
        passwordField = new PasswordField();
        loginField = new TextField();
        loginLabel = new Label("Login: ");
        passwordLabel = new Label("Password: "); 
        bankName = new Label("Eagle Bank");
        bankName.setFont(new Font("Times New Roman", 30));
        login = new Button("Login");
        login.setPrefSize(90, 30);
        incorrect = new Label("Incorrect name or password!");
        incorrect.setTextFill(Color.RED);

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);   
        pane.setVgap(20);
        pane.add(loginField, 1, 1);
        pane.add(passwordField, 1, 2);
        pane.add(loginLabel, 0, 1);
        pane.add(passwordLabel, 0, 2);
        pane.add(bankName, 0, 0, 2, 1);
        pane.add(login, 2, 3);
        pane.add(createAccount, 2, 4);
        pane.add(incorrect, 0, 3);
        incorrect.setVisible(false);
        this.setCenter(pane);
        
        
        //TODO possibly change this to prevent checking when it is empty
        login.setOnAction((e) -> checkLogin());
        createAccount.setOnAction((e) -> navigateToCreate());
        

    }

    private void checkLogin(){
        try{
            if (bank.validLogin(loginField.getText(), passwordField.getText())){
                bank.acountNumber = loginField.getText();
                bank.logger.add("Login From Acount #" + loginField.getText());
                navigateToMain();
            } else {
                incorrect.setVisible(true);
            }
        } catch (FileNotFoundException e){
            
        }
       
    }

    public void navigateToMain() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.MAINPAGE));
    }

    public void navigateToCreate() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.CREATE));
    }

    public int getLogin(){
        return Integer.parseInt(loginField.getText());
    }

}
