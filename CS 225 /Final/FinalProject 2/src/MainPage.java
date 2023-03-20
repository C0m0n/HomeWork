import java.io.IOException;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class MainPage extends BorderPane{
    GridPane gridPane, rGridPane, lGridPane;
    Button getAcountInfo, deposit, withdraw, quickWithdraw, quickDeposit, transfer, createNewAccount;
    Pane pane;
    Acount acount;
    EagleBank bank;
    Label accountNumber, balance, lAcountNumber, lBalance, tooMuchLabel, withdrew, deposited, depositLabel, withdrawLabel;
    ListView listView;
    VBox vBox;
    Boolean labelsDrawn = false;


    MainPage(EagleBank bank){
        //Set the bank to the bank that was passed
        this.bank = bank;

        //Create the gridpane and button objects
        gridPane = new GridPane();
        rGridPane = new GridPane();
        lGridPane = new GridPane();
        transfer = new Button("Transfer Funds");
        getAcountInfo = new Button("Get Account Info");
        deposit = new Button("Deposit");
        withdraw = new Button("Withdraw");
        quickDeposit = new Button("Quick deposit");
        quickWithdraw = new Button("Quick withdraw");
        lBalance = new Label("Balance: ");
        lAcountNumber = new Label("Acount Number: ");
        tooMuchLabel = new Label();
        tooMuchLabel.setText("Not enought funds to transfer");
        tooMuchLabel.setTextFill(Paint.valueOf("red"));
        tooMuchLabel.setVisible(false);
        accountNumber = new Label();
        accountNumber.setText(bank.acountNumber);
        balance = new Label();
        balance.setText("********");
        accountNumber.setText("*******");
        vBox = new VBox();
        listView = new ListView();
        withdrew = new Label("Withdrew 200$");
        deposited = new Label("Deposited 200$");
        depositLabel = new Label("Ammount to deposit");
        withdrawLabel = new Label("Ammount to withdraw");
        gridPane.add(deposited, 3, 0);
        gridPane.add(withdrew, 3, 0);
        gridPane.add(depositLabel, 1, 0);
        gridPane.add(withdrawLabel, 1, 0);
        withdrawLabel.setVisible(false);
        depositLabel.setVisible(false);
        deposited.setVisible(false);
        withdrew.setVisible(false);
        //Create the eventhandeler to handle to get the account information
        getAcountInfo.setOnMouseClicked((e)->drawLabels());

        //Event handeler to navigate to the transfer screen
        transfer.setOnMouseClicked((e) -> navigateToTransfer());

        //Event handeler to deposit
        deposit.setOnMouseClicked((e)->{
            //Update the balance
            drawLabels();
            //Create new textfields for deposit
            TextField depositText = new TextField();
            gridPane.add(depositText, 1, 1);
            Button depositConfirm = new Button("Confirm");
            gridPane.add(depositConfirm, 1, 2);
            withdrawLabel.setVisible(false);
            depositLabel.setVisible(true);

            //Event handeler for when the deposit button is clicked
            depositConfirm.setOnMouseClicked((t)->{
                //Deposit the money into the account
                bank.logger.add("Deposit " + depositText.getText());
                acount.deposit(Double.parseDouble(depositText.getText()));
                //Update the balance on screen
                drawLabels();
                //Hide the fields
                depositConfirm.setVisible(false);
                depositText.setVisible(false);
                depositLabel.setVisible(false);
            });
            
        });

        //Event handeler to withdrawl
        withdraw.setOnMouseClicked((e)->{
            //Update the balance
            drawLabels();
            //Create the new textfields
            TextField withdrawText = new TextField();
            gridPane.add(withdrawText, 1, 1);
            Button withdrawConfirm = new Button("Confirm");
            gridPane.add(withdrawConfirm, 1, 2);
            depositLabel.setVisible(false);
            withdrawLabel.setVisible(true);
            //Event handeler for when the withdrawl button is clicked
            withdrawConfirm.setOnMouseClicked((t)->{
                //Check to see if it is a valid withddrawl
                if (acount.validWithdrawl(Double.parseDouble(withdrawText.getText()))){
                    //If it is valid withdraw from the account
                    bank.logger.add("Withdrawl " + withdrawText.getText());
                    acount.withdraw(Double.parseDouble(withdrawText.getText()));
                    //Update the balance
                    drawLabels();
                    //Hide the fields
                    withdrawConfirm.setVisible(false);
                    withdrawText.setVisible(false);
                    tooMuchLabel.setVisible(false);
                    withdrawLabel.setVisible(false);
                } else {
                    //Show the label for withdrawing too much
                    tooMuchLabel.setVisible(true);
                }
                
            });
            
        });

        quickWithdraw.setOnMouseClicked((e) ->{
            drawLabels();
            deposited.setVisible(false);
            withdrew.setVisible(true);
            if (acount.validWithdrawl(Double.parseDouble("200"))){
                bank.logger.add("Quick Withdrawl");
                acount.withdraw(Double.parseDouble("200"));
            }
        });

        quickDeposit.setOnMouseClicked((e) ->{
            withdrew.setVisible(false);
            deposited.setVisible(true);
            bank.logger.add("Quick Deposit");
            acount.deposit(200);
            drawLabels();
        });
    
        //Add the elements to the gridpane
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
        gridPane.add(transfer, 0, 6);
        gridPane.add(tooMuchLabel, 1, 6);
        vBox.getChildren().addAll(listView);
        
        //Set the location of the different gridpanes
        this.setCenter(gridPane);
        this.setLeft(lGridPane);
        this.setRight(vBox);
        
        
     
    }
    //Method for updating the account number and balance
    public void drawLabels(){
        try{
            //Update labelsDrawn
            labelsDrawn = true;
            //Create new account object
            acount = new Acount(Integer.parseInt(bank.acountNumber)); 
            //Set the balance label with the balance of the account object
            balance.setText(String.valueOf(acount.getBalance()));
            //Get the account history and store it in a list
            List<String> getAcountHistory = acount.getAcountHistory();
            //Loop through the list and add it to the listview element
            listView.getItems().clear();
            for(int i = 0; i < getAcountHistory.size(); i++){
                listView.getItems().add(getAcountHistory.get(i));
            }
            //Set the acount number label with the account number
            accountNumber.setText(bank.acountNumber);
            } catch (IOException e){
                System.out.println("ERRROR");
            }
           
        
    }
    public void navigateToTransfer() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.TRANSFER));
    }
}
