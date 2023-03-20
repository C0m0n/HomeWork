import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Create extends BorderPane{
    
    private Button createAccount;
    private PasswordField passwordField;
    private TextField loginField;
    private Label loginLabel, passwordLabel, bankName, alreadyUsed;
    private GridPane pane;
    
    
    EagleBank bank;
    Create(EagleBank bank){
        this.bank = bank;
        pane = new GridPane();
        passwordField = new PasswordField();
        loginField = new TextField();
        loginLabel = new Label("Login: ");
        passwordLabel = new Label("Password: "); 
        bankName = new Label("Create New Account");
        bankName.setFont(new Font("Times New Roman", 30));
        createAccount = new Button("Create Account");
        createAccount.setPrefSize(120, 30);
        alreadyUsed = new Label("Account number already in use!");
        alreadyUsed.setTextFill(Color.RED);

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);
        pane.add(loginField, 1, 1);
        pane.add(passwordField, 1, 2);
        pane.add(loginLabel, 0, 1);
        pane.add(passwordLabel, 0, 2);
        pane.add(bankName, 0, 0, 2, 1);
        pane.add(createAccount, 2, 3);
        pane.add(alreadyUsed, 0, 3);
        alreadyUsed.setVisible(false);
        this.setCenter(pane);
        createAccount.setOnAction((e) -> {
            try {
                bank.logger.add("Created account # " + loginField.getText());
                new Acount(Integer.parseInt(loginField.getText()), Integer.parseInt(passwordField.getText()));
                navigateToLogin();
            } catch (NumberFormatException e1) {
              
                e1.printStackTrace();
            } catch (IOException e1) {
  
                e1.printStackTrace();
            }
        });
    }


    public void navigateToLogin() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.LOGIN));
    }

    
}
