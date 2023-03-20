import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainPage extends BorderPane{
    GridPane gridPane, rGridPane, lGridPane;
    Button getAcountInfo, deposit, withdraw, quickWithdraw, quickDeposit, transfer, createNewAccount;
    Pane pane;
    Acount acount;
    EagleBank bank;
    Label accountNumber, balance, lAcountNumber, lBalance;
    Boolean labelsDrawn = false;


    MainPage(EagleBank bank){
        this.bank = bank;
        gridPane = new GridPane();
        rGridPane = new GridPane();
        lGridPane = new GridPane();
        getAcountInfo = new Button("Get Account Info");
        deposit = new Button("Deposit");
        withdraw = new Button("Withdraw");
        quickDeposit = new Button("Quick deposit");
        quickWithdraw = new Button("Quick withdraw");
        lBalance = new Label("Balance: ");
        lAcountNumber = new Label("Acount Number: ");
        
        accountNumber = new Label();
        accountNumber.setText(bank.acountNumber);
        
        //dropDownLabel.setPrefWidth(200);
        balance = new Label();
        balance.setText("********");
        accountNumber.setText("*******");
        
        getAcountInfo.setOnMouseClicked((e)->drawLabels());
        deposit.setOnMouseClicked((e)->{
            drawLabels();
            TextField depositText = new TextField();
            gridPane.add(depositText, 3, 0);
            Button depositConfirm = new Button("Confirm");
            gridPane.add(depositConfirm, 5, 5);
            depositConfirm.setOnMouseClicked((t)->{
                acount.deposit(Double.parseDouble(depositText.getText()));
                System.out.println(Double.parseDouble(depositText.getText()));
                drawLabels();
                depositConfirm.setVisible(false);
                depositText.setVisible(false);
            });
            
        });
        withdraw.setOnMouseClicked((e)->{
            drawLabels();
            TextField withdrawText = new TextField();
            gridPane.add(withdrawText, 3, 0);
            Button withdrawConfirm = new Button("Confirm");
            gridPane.add(withdrawConfirm, 5, 5);
            withdrawConfirm.setOnMouseClicked((t)->{
                acount.withdraw(Double.parseDouble(withdrawText.getText()));
                System.out.println(Double.parseDouble(withdrawText.getText()));
                drawLabels();
                withdrawConfirm.setVisible(false);
                withdrawText.setVisible(false);
            });
            
        });
        //dropDown.setPrefWidth(400);
        //dropDown.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    
        
        
        gridPane.setAlignment(Pos.CENTER);
        balance.setPrefSize(50, 50);
        lGridPane.add(getAcountInfo, 0, 0, 1, 2);
        lGridPane.add(balance, 1, 6);
        lGridPane.add(accountNumber, 1, 4);
        lGridPane.add(lAcountNumber, 0, 4);
        lGridPane.add(lBalance, 0, 6);
        
        gridPane.add(deposit, 0, 2);
        gridPane.add(withdraw, 0, 3);
        gridPane.add(quickDeposit, 0, 4);
        gridPane.add(quickWithdraw, 0, 5);
        
        this.setCenter(gridPane);
        this.setLeft(lGridPane);
        this.setRight(rGridPane);
        
        
     
    }
    public void drawLabels(){
        try{
            labelsDrawn = true;
            System.out.println(Integer.parseInt(bank.acountNumber));
            acount = new Acount(Integer.parseInt(bank.acountNumber)); 
            
            
            balance.setText(String.valueOf(acount.getBalance()));
            accountNumber.setText(bank.acountNumber);

            } catch (IOException e){
                System.out.println("ERRROR");
            }
           
        
    }
    
}
