import java.io.FileNotFoundException;
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

public class ChangePin extends BorderPane{
    
    private Button changePin;
    private PasswordField oldPasswordField, newPasswordField;
    private TextField loginField;
    private Label loginLabel, oldPasswordLabel, bankName, alreadyUsed, newPasswordLabel;
    private GridPane pane;
    
    
    EagleBank bank;
    ChangePin(EagleBank bank){
        this.bank = bank;
        pane = new GridPane();
        oldPasswordField = new PasswordField();
        newPasswordField = new PasswordField();
        newPasswordLabel = new Label("New pin: ");
        loginField = new TextField();
        loginLabel = new Label("Acount number: ");
        oldPasswordLabel = new Label("Old Password: "); 
        bankName = new Label("Change Pin");
        bankName.setFont(new Font("Times New Roman", 30));
        changePin = new Button("Change Pin");
        changePin.setPrefSize(120, 30);
        alreadyUsed = new Label("Error in acount number or pin");
        alreadyUsed.setTextFill(Color.RED);

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);
        pane.add(loginField, 1, 1);
        pane.add(oldPasswordField, 1, 2);
        pane.add(loginLabel, 0, 1);
        pane.add(oldPasswordLabel, 0, 2);
        pane.add(bankName, 0, 0, 2, 1);
        pane.add(changePin, 3, 3);
        pane.add(alreadyUsed, 0, 3);
        pane.add(newPasswordField, 1, 3);
        pane.add(newPasswordLabel, 0, 3);
        alreadyUsed.setVisible(false);
        this.setCenter(pane);
        changePin.setOnAction((e) -> {
            try {
                checkLogin();
            } catch (NumberFormatException e1) {
              
                e1.printStackTrace();
            }
        });
    }

    private void checkLogin(){
        try{
            if (bank.validLogin(loginField.getText(), oldPasswordField.getText())){
                Acount acount = new Acount(Integer.parseInt(loginField.getText()));
                bank.logger.add("Changed Pin of Account # " + loginField.getText());
                acount.changePin(Integer.parseInt(newPasswordField.getText()));
                navigateToLogin();
            } else {
                alreadyUsed.setVisible(true);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
       
    }

    public void navigateToLogin() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.LOGIN));
    }

    
}
